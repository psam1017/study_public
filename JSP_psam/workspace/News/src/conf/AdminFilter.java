package conf;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/app/conf/PropertiesTest.jsp")
public class AdminFilter implements Filter {
	
	Properties properties;
	
  public AdminFilter() { ; }

	public void destroy() { ; }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		properties = (Properties) request.getServletContext().getAttribute("properties");
		properties.put("admin", "supervisor");
		request.setAttribute("tel", "010-1234-5678");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException { ; }
}
