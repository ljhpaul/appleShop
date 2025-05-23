package com.shinhan.controller.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcart2.do")
public class CartServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getRequestDispatcher("jsp/addCart2.jsp").forward(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		long count = Long.parseLong(request.getParameter("count"));
		
		//세션에 저장된 cart 읽어봄
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<String, Long> cart = null;
		
		//있으면 같은 상품이 있는지 보고, 같은 상품이면 갯수를 수정한다.
		if(obj == null) {	//없으면 cart 만듦
			cart = new HashMap<>();
			cart.put(product, count);
			session.setAttribute("cart", cart);
		} else {	//있으면 형변환
			cart = ( Map<String, Long> ) obj;
			if(cart.containsKey(product)) {
				cart.put(product, cart.get(product) + count);
			} else {
				cart.put(product, count);
			}
		}
		
		/* session.setAttribute("cart", cart); */
		
		response.sendRedirect("addcart2.do");
	}

}
