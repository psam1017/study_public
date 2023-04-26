package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public MySessionListener() { ; }
    
    public void sessionCreated(HttpSessionEvent se)  { 
    	
    	se.getSession().getServletContext().log("★★★Session 생성됨 : " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	
    	se.getSession().getServletContext().log("★★★Session 종료됨");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	
    	se.getSession().getServletContext().log("★★★Session 속성 추가됨 : " + se.getValue());
    }
    
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	
    	se.getSession().getServletContext().log("★★★Session 속성 대체됨 : " + se.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  {
    	
    	se.getSession().getServletContext().log("★★★Session 속성 삭제됨");
    }
}
