package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {

    public MyServletContextListener() { ; }
    
    public void contextInitialized(ServletContextEvent sce)  {
    	
    	ServletContext sc = sce.getServletContext();
    	String msg = "Hello Listener!";
    	sc.setAttribute("msg", msg);
    	sce.getServletContext().log("★★★servlet context 초기화");
    }
    public void contextDestroyed(ServletContextEvent sce)  {
    	
    	sce.getServletContext().log("★★★servlet context 종료");
    }
    
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	
    	scae.getServletContext().log("★★★servlet context에 속성이 추가됨 : " + scae.getValue());
    }
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	
    	// 속성 변경. 할 일이 있나?
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	
    	// 속성 삭제. 할 일이 있나?
    }
}
