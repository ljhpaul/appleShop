package com.shinhan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    public AppListener() {
    	
    	//System.out.println("AppListener ... 생성자");
    	
    }

	public void contextDestroyed(ServletContextEvent sce) {
		
//		System.out.println("=== 웹프로그램 종료 ===");
		
    }

	public void contextInitialized(ServletContextEvent sce) {
		
		String cpath = sce.getServletContext().getContextPath();
		sce.getServletContext().setAttribute("version", "1.0");
		//System.out.println("ServletContextListener ... contextInitialized 초기화 : " + cpath);
		
    }
	
}
