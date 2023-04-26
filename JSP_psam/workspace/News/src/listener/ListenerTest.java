package listener;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/listen")
public class ListenerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
  ServletContext sc;
	
  public ListenerTest() {
      super();
  }
  
  public void init(ServletConfig config) throws ServletException{
  	
  	super.init(config);
  	sc = getServletContext();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		sc.setAttribute("name", "psam");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", "psam1017");
		
		// redirect를 하면 servlet context에 속성이 추가된다.
		response.sendRedirect(request.getContextPath() + "/app/listener/listenerTest.jsp");
	}
}
