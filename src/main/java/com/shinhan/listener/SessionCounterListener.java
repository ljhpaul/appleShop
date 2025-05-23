package com.shinhan.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounterListener implements HttpSessionListener {
	
	private static int activeSessions = 0;
	
    public SessionCounterListener() {
        
    }

	public void sessionCreated(HttpSessionEvent se)  { 
		activeSessions++;
		ServletContext app = se.getSession().getServletContext();
		app.setAttribute("activeSessions", activeSessions);
		System.out.println("[ sessionCreated | 접속자수: " + activeSessions + " ]");
    }

	public void sessionDestroyed(HttpSessionEvent se)  { 
		activeSessions--;
		ServletContext app = se.getSession().getServletContext();
		app.setAttribute("activeSessions", activeSessions);
		System.out.println("[ sessionDestroyed | 접속자수: " + activeSessions + " ]");
    }
	
}
