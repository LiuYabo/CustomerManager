package edu.xidian.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CountListener implements HttpSessionListener {
    
	static int count = 0;
    public void sessionCreated(HttpSessionEvent se)  { 

    	count=count+1;
    	ServletContext servletContext = se.getSession().getServletContext();
    	System.out.println("this is listener");
    	System.out.println(count);
    	servletContext.setAttribute("count", count);
    	
    	/*Integer count = (Integer) servletContext.getAttribute("count");
    	
    	if (count == null) {
    		count = 1;
    		servletContext.setAttribute("count", count);
    	} else {
    		count++;
    		servletContext.setAttribute("count", count);
    	}
    	
    	
    	*/
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	/*
    	ServletContext servletContext = se.getSession().getServletContext();
    	Integer count = (Integer) servletContext.getAttribute("count");
    	count--;
    	servletContext.setAttribute("count", count);
        */
    }
	
}
