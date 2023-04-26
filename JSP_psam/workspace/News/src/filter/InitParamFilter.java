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
public class InitParamFilter implements Filter {
	
	private FilterConfig fConfig = null;

  public InitParamFilter() { ; }

	public void destroy() { ; }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String idCheck = fConfig.getInitParameter("id");
		String pwCheck = fConfig.getInitParameter("pw");
		
		String message;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		if(id.equals(idCheck)&&pw.equals(pwCheck)) {
			message = "로그인 성공";
		}
		else {
			message = "로그인 실패";
		}
		
		writer.print(message);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}
}
