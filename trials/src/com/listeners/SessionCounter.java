package com.listeners;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounter implements HttpSessionListener {

	ArrayList<String> list = new ArrayList<>();
	public static final String COUNTER = "session-counter";
	
    /**
     * Default constructor. 
     */
    public SessionCounter() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		
		HttpSession hs = event.getSession();
    	list.add(hs.getId());
    	hs.setAttribute(SessionCounter.COUNTER, this);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
        
   	HttpSession hs = event.getSession();
   	list.remove(hs.getId());
   	hs.setAttribute(SessionCounter.COUNTER, this);
		
	}
	
	public int getActiveSessionNumber()
	{
		return list.size();
	}

	
}
