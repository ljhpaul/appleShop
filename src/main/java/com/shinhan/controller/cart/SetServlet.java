package com.shinhan.controller.cart;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.emp.EmpService;

@WebServlet("/set")
public class SetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext : application당 하나, 서버종료시 소멸된다.
    	
    	ServletContext app = getServletContext();
    	app.setAttribute("connectName", request.getParameter("name"));	//String
    	app.setAttribute("emplist", new EmpService().selectAll());		//List
    	app.setAttribute("emp", new EmpService().selectById(100));		//EmpDTO
    	
    	response.setContentType("text/html;charset=utf-8");
    	response.getWriter().append("<h1>ServletContext에 setting함</h1>");
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
