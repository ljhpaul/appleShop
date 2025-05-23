package com.shinhan.controller.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartViewServlet
 */
@WebServlet("/viewcart.do")
public class CartViewServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<ul>");
		Cookie[] cs = request.getCookies();
		int cnt = 0;
		for(Cookie cookie : cs) {
			if(cookie.getName().equals("subject") || cookie.getName().equals("JSESSIONID")) continue;
			out.print("<li>" + cookie.getName() + " ==> " + cookie.getValue() + "</li>");
		}
		out.print("</ul>");
		
	}
    
    
}
