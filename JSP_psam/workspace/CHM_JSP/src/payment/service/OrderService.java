package payment.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import mvc.dao.CartDAO;
import mvc.dto.CartDTO;
import payment.domain.OrderData;
import payment.domain.OrderInfo;
import payment.repository.OrderRepository;

public class OrderService {

	public String getOrderNo(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String orderNo = (String) session.getAttribute("orderNo");
		if(orderNo == null) {
			orderNo = this.generateOrderNo(req);
			session.setAttribute("orderNo", orderNo);
		}
		return orderNo;
	}
	
	public String generateOrderNo(HttpServletRequest req) {
		LocalDateTime now = LocalDateTime.now();
		String nowStr = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		HttpSession session = req.getSession();
		return nowStr + "-" + session.getId();
	}
	
	public void setOrderData(HttpServletRequest req) {
		
		OrderRepository repo = OrderRepository.getInstance();
		String orderNo = this.getOrderNo(req);
		
		repo.clearOrderData(orderNo);
		
		try {
			// CartDAO cartDAO = new CartDAO();
			// List<CartDTO> carts = cartDAO.getCartList(orderNo);
			CartDAO cartDAO = new CartDAO();
			List<CartDTO> carts = cartDAO.getCartList(req.getSession().getId());
			List<OrderData> datas = this.changeCartData(carts, orderNo);
			for(OrderData data : datas) {
				repo.insertOrderData(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private List<OrderData> changeCartData(List<CartDTO> carts, String orderNo){
		List<OrderData> datas = new ArrayList<>();
		for(CartDTO cart : carts) {
			OrderData data = new OrderData();
			data.setOrderNo(orderNo);
			data.setCartId(cart.getCartId());
			data.setBookId(cart.getProductId());
			data.setBookName(cart.getName());
			data.setUnitPrice(cart.getUnitPrice());
			data.setCnt(cart.getCnt());
			data.setSumPrice(cart.getUnitPrice() * cart.getCnt());
			datas.add(data);
		}
		return datas;
	}
	
	public List<OrderData> getOrderData(String orderNo) {
		
		OrderRepository repo = OrderRepository.getInstance();
		return repo.selectAllOrderData(orderNo);
	}
	
	public int getTotalPrice(String orderNo) {
		OrderRepository repo = OrderRepository.getInstance();
		return repo.getTotalPrice(orderNo);
	}
	
	public void setOrderInfo(HttpServletRequest req) {
		
		OrderRepository repo = OrderRepository.getInstance();
		
		repo.clearOrderData(this.getOrderNo(req));
		
		OrderInfo info = new OrderInfo();
		
		info.setOrderNo(this.getOrderNo(req));
		info.setMemberId(this.getMemberId(req));
		info.setOrderName(req.getParameter("orderName"));
		info.setOrderTel(req.getParameter("orderTel"));
		info.setOrderEmail(req.getParameter("orderEmail"));
		info.setReceiveName(req.getParameter("receiveName"));
		info.setReceiveTel(req.getParameter("receiveTel"));
		info.setReceiveAddress(req.getParameter("receiveAddress"));
		info.setPayAmount(req.getParameter("payAmount"));
		
		repo.insertOrderInfo(info);
	}
	
	public String getMemberId(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		return (String) session.getAttribute("sessionMemberId");
	}
	
	public OrderInfo getOrderInfo(String orderNo) {
		
		return null;
	}
	
	public String getOrderProductName(String orderNo) {
		
		OrderRepository repo = OrderRepository.getInstance();
		return repo.getOrderProductName(orderNo);
	}
	
	@SuppressWarnings("unchecked")
	public String processSuccess(HttpServletRequest req) throws Exception {
		
		String orderId = req.getParameter("orderId");
		String paymentKey = req.getParameter("paymentKey");
		String amount = req.getParameter("amount");
		
		String secretKey = "토스에서 발급 받은 secretKey";
		
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(secretKey.getBytes("UTF-8"));
		String auth = "Basic " + new String(encodedBytes, 0, encodedBytes.length);
		
		URL url = new URL("https://api.tosspayments.com/v1/payments/" + paymentKey);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestProperty("Authorization", auth);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("orderId", orderId);
		obj.put("amount", amount);
		
		OutputStream os = conn.getOutputStream();
		os.write(obj.toString().getBytes("UTF-8"));
		
		int code = conn.getResponseCode();
		
		boolean isSuccess = code >= 200 && code < 300 ? true : false;
		
		InputStream is = isSuccess ? conn.getInputStream() : conn.getErrorStream();
		Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(reader);
		is.close();
		
		if(isSuccess) {
			
			String method = (String) jsonObj.get("method");
			OrderInfo info = new OrderInfo();
			info.setOrderNo((String) jsonObj.get("orderId"));
			info.setPayMethod(method);
			
			if(method.equals("가상계좌")) {
				info.setOrderStep(String.valueOf(OrderStep.orderReceive));
			}
			else {
				info.setOrderStep(String.valueOf(OrderStep.payReceive));
				info.setDatePay((String) jsonObj.get("approvceAt"));
			}
			this.processSuccessUpdate(info);
		}
		return null;
	}
	
	private boolean processSuccessUpdate(OrderInfo info) {
		
		OrderRepository repo = OrderRepository.getInstance();
		return repo.updateOrderInfoWhenProcessSuccess(info);
	}
	
	public void deleteCartWhenOrderDone(HttpServletRequest req) {
		
		OrderRepository repo = OrderRepository.getInstance();
		CartDAO cartDAO = new CartDAO();
		
		HttpSession session = req.getSession();
		
		List<OrderData> datas = repo.selectAllOrderData(this.getOrderNo(req));
		for(OrderData data : datas) {
			try {
				cartDAO.deleteCartById(session.getId(), data.getCartId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
