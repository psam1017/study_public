package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// annotation 대신 web.xml에서 mapping을 사용
public class AuthFilter implements Filter {

  public AuthFilter() { ; }

	public void destroy() { ; }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		
		if(name == null || name.equals("")) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String message = "잘못된 값이 입력되었습니다.";
			writer.print(message);
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { ; }
}
