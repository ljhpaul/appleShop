package com.shinhan.controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/setcookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("coffee", "아메리카노");
		Cookie cookie2 = new Cookie("subject", "서블릿");
		
		cookie1.setMaxAge(2 * 60);	//2분유효
		cookie1.setMaxAge(60 * 60 * 24);  //24시간유효
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	}
	
}
