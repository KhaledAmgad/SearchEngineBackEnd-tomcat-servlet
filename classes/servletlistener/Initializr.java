package servletlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import servletlistener.QueryProcessor;
 

public class Initializr implements ServletContextListener {
 

    public void contextInitialized(ServletContextEvent event) {
 
    	ServletContext sc = event.getServletContext();
		QueryProcessor QP= new QueryProcessor();
    	sc.setAttribute("QP", QP);
 
    }
 
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
 
}