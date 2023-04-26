package payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.CartDTO;
import payment.domain.OrderData;
import payment.domain.OrderInfo;
import payment.service.OrderService;
import payment.service.OrderStep;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderService service = new OrderService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		resp.setContentType("text/html charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		// test code
		System.out.println(command);
		System.out.println(service.getOrderNo(req));
		
		if(command.contains("form.do")) {
			service.setOrderData(req);
			
			List<OrderData> datas = service.getOrderData(service.getOrderNo(req));
			req.setAttribute("datas", datas);
			
			int totalPrice = service.getTotalPrice(service.getOrderNo(req));
			req.setAttribute("totalPrice", totalPrice);
			
			req.getRequestDispatcher("/LECTURE/market_payment/order/form.jsp").forward(req, resp);
		}
		else if(command.contains("pay.do")) {
			
			service.setOrderData(req);
			
			String orderNo = service.getOrderNo(req);
			
			int totalPrice = service.getTotalPrice(orderNo);
			req.setAttribute("totalPrice", totalPrice);
			
			OrderInfo info = service.getOrderInfo(orderNo);
			req.setAttribute("info", info);
			
			String orderProductName = service.getOrderProductName(orderNo);
			req.setAttribute("orderProductName", orderProductName);
			
			req.getRequestDispatcher("/LECTURE/market_payment/order/pay.jsp").forward(req, resp);
		}
		else if(command.contains("success.do")) {
			
			try {
				service.processSuccess(req);
				resp.sendRedirect("/order/orderDone.do");
			}
			catch(Exception e) {
				throw new RuntimeException();
			}
		}
		else if(command.contains("orderDone.do")) {
			
			String orderNo = service.getOrderNo(req);
			
			service.deleteCartWhenOrderDone(req);
			
			List<OrderData> datas = service.getOrderData(orderNo);
			req.setAttribute("datas", datas);
			
			// 주문단계 설정
			OrderInfo info = service.getOrderInfo(orderNo);
			OrderStep orderStep = OrderStep.valueOf(info.getOrderStep());
			info.setOrderStep(orderStep.getStep());
			req.setAttribute("info", info);
			
			// 주문 번호 삭제
			req.getSession().removeAttribute("orderNo");
			
			req.getRequestDispatcher("/LECTURE/market_payment/order/orderDone.jsp").forward(req, resp);
		}
	}
}
