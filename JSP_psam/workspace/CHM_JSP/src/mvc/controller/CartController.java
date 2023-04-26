package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _06_action_tags.market.dto.ProductDTO;
import mvc.dao.CartDAO;
import mvc.dao.ProductDAO;
import mvc.dto.CartDTO;

@WebServlet(urlPatterns = {"/shop_db/add_cart.jsp", "/shop_db/cart.jsp"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String RequestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		if(command.contains("add_cart.jsp")) {
			String productID = req.getParameter("productID");
			HttpSession session = req.getSession();
			
			if(productID == null || productID.trim().equals("")){
				resp.sendRedirect("market2.jsp");
				return;
			}
			
			ProductDAO dao = new ProductDAO();
			
			ProductDTO product = dao.getProductById(productID);
			if(product == null){
				resp.sendRedirect("exceptionNoProductId.jsp");
			}
			
			String orderNo = session.getId();
			String memberId = (String) session.getAttribute("sessionID");
			
			CartDAO cartDao = new CartDAO();
			
			cartDao.updateCart(product, orderNo, memberId);
			
			resp.sendRedirect("product.jsp?productID=" + productID);
		}
		else if(command.contains("add_cart.jsp")) {
			
			HttpSession session = req.getSession();
			CartDAO cartDAO = new CartDAO();
			String orderNO = session.getId();
			
			ArrayList<CartDTO> cartArrayList = cartDAO.getCartList(orderNO);
			
			req.setAttribute("cartArrayList", cartArrayList);
		}
	}
}
