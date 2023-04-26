package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// annotation 대신 web.xml에서 mapping을 사용
public class LogFilter implements Filter {
	
	PrintWriter writer;
	
  public LogFilter() { ; }

	public void destroy() {
		writer.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String clientAddr = request.getRemoteAddr();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		String now = format.format(cal.getTime());
		
		writer.println("현재 일시 : " + now);
		writer.println("클라이언트 주소 : " + clientAddr);
		
		chain.doFilter(request, response);
		
		String contentType = response.getContentType();
		writer.println("문서 컨텐츠 유형 : " + contentType);
		writer.println();
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String filename = fConfig.getInitParameter("filename");
		if(filename == null) {
			throw new ServletException("로그 파일을 찾을 수 없습니다.");
		}
		
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
}
