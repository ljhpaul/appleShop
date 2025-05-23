package com.shinhan.controller.pattern;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * URL패턴이 일치하는 것이 있으면 우선
 * 없으면 * 또는 확장자일치로 간다.
 */
//@WebServlet("/aa/bb")
//@WebServlet("/aa/*")
//@WebServlet("*.do")
//@WebServlet("/*")	/* 모든요청 : 제일 강력 */
public class URLPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("URL pattern 테스트: ").append(request.getContextPath());
	}

}
