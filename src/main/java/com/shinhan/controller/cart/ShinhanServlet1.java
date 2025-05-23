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
 * 요청주소  ==>  http://localhost:9090/appleShop/one
 * 응답페이지 ==> http://localhost:9090/appleShop/jsp/one.jsp
 * forward는 주소창이 변경되지 않는다. 즉, request가 유지된다.
 */
@WebServlet("/one")
public class ShinhanServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession();	//브라우저 세션이 유지되는 동안(기본 30분, 로그인 세션에 사용..)
//    	ServletContext app = request.getServletContext();
    	ServletContext app = getServletContext();	//서버가 종료될때까지 계속 유지, 공유(global)
    	
    	request.setAttribute("message1", "request메시지");
    	
    	String myname = request.getParameter("myname");
    	System.out.println("접속한 사용자의 이름: " + myname);
    	session.setAttribute("message2", myname);
    	
    	app.setAttribute("message3", myname);
    	
    	//forward는 request가 유지(전달)됨!
    	request.getRequestDispatcher("jsp/one.jsp").forward(request, response);
    	
    	//request 재지정(새로운 request 발생), 주소창이 변경된다.(새로운 요청이 생김, 요청이 유지되지 않음!)
//    	response.sendRedirect("two");
    	
	}
}
