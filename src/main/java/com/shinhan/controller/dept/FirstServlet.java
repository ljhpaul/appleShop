package com.shinhan.controller.dept;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet : 자바로 작성된 서버프로그램이다.
 * 요청의 주소에 따라 이 서블릿이 수행된다.
 * 최초 요청시 객체가 생성됨(객체는 한 번). 각자 요청의 thread가 만들어진다.(멀티쓰레드)
 * 서블릿 default경로-> contextPath : /appleShop ... 그 이후의 경로를 써주면 됨
 */
@WebServlet({ "/FirstServlet", "/first", "/first2" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public FirstServlet() {
    	System.out.println("FirstServlet 생성자");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init");
	}

	public void destroy() {
		System.out.println("FirstServlet destroy .. 서버가 중지되면 소멸된다.");
	}

//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("public ... service 요청시마다 수행된다.");
//	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("protected ... service 요청시마다 수행된다.");
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String remote = req.getRemoteAddr();
		System.out.println("protected ... get 요청시마다 수행된다." + remote);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("protected ... post 요청시마다 수행된다.");
	}
}
