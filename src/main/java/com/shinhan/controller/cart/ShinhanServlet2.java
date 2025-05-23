package com.shinhan.controller.cart;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShinhanServlet2
 */
@WebServlet("/two")
public class ShinhanServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession();
    	ServletContext app = getServletContext();
		
		//getAttribute는 무조건 Object를 리턴! -> 형변환 해야함
		String message1 = (String) request.getAttribute("message1");
		String message2 = (String) session.getAttribute("message2");
		String message3 = (String) app.getAttribute("message3");
		
		System.out.println("request에 저장된 data얻기: " + message1);
		System.out.println("session에 저장된 data얻기: " + message2);
		System.out.println("application에 저장된 data얻기: " + message3);
		
	}

}
