package com.shinhan.controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addcart.do")
public class CartServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getRequestDispatcher("jsp/addCart.jsp").forward(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product = request.getParameter("product");
		long count = Long.parseLong(request.getParameter("count"));
		
//		System.out.println(product + " " + count);
		
//		if(product.equals("no")) {
//			response.sendRedirect("addcart.do");
//			return;
//		}
		
		Cookie cookie = new Cookie(product, String.valueOf(count));
		
		Cookie[] cs = request.getCookies();
		for(Cookie c : cs) {
			if(c.getName().equals(product)) {
				
				cookie = new Cookie( product, String.valueOf(Long.parseLong(c.getValue()) + count) );
			}
		}
		
		if(!product.equals("no")) {
			cookie.setMaxAge(24*60*60);
			response.addCookie(cookie);
		}
		
		response.sendRedirect("addcart.do");
		
		
	}

}
