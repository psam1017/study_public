package conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PropertyListener implements ServletContextListener {

    public PropertyListener() { ; }

    public void contextDestroyed(ServletContextEvent sce)  { ; }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext ctx = sce.getServletContext();
    	String file = ctx.getInitParameter("propfile");
    	
    	Properties properties = new Properties();
    	
    	try {
				properties.load(new FileInputStream(file));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
    	
    	ctx.setAttribute("properties", properties);
    }
}
