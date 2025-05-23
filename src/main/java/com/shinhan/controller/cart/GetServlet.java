package com.shinhan.controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.emp.EmpDTO;
import com.shinhan.model.emp.EmpService;

//@WebServlet(urlPatterns = {"/get2"}, initParams = {@WebInitParam(name="lunch2", value="aa")})
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public GetServlet() {
		System.out.println("GetServlet생성자");
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext : application당 하나, 서버종료시 소멸된다.
    	
    	ServletContext app = getServletContext();
    	String name = (String) app.getAttribute("connectName");		//String
    	List<EmpDTO> emplist = (List<EmpDTO>) app.getAttribute("emplist");	//List
    	EmpDTO emp = (EmpDTO) app.getAttribute("emp");				//EmpDTO
    	
    	//web.xml의 context-param을 읽기
    	String dbname = app.getInitParameter("DBName");
    	String id = app.getInitParameter("userId");
    	String pass = app.getInitParameter("userPass");
    	
    	//web.xml의 servlet의 init-param읽기
    	String lunch = getInitParameter("lunch");
    	
    	//현재 프로그램이 실행되고 있는 실제위치?
    	String path = app.getRealPath(".");
    	
    	//"" = null => null
    	response.setContentType("text/html;charset=utf-8");
    	response.getWriter()
    			.append("<h1>ServletContext에 getting함</h1>")
    			.append("<h1>name: " + name + "</h1>")
    			.append("<h1>emplist건수: " + emplist.size() + "</h1>")
    			.append("<h1>EmpDTO정보: " + emp + "</h1>")
    			.append("<h2>dbname정보: " + dbname + "</h2>")
    			.append("<h2>id정보: " + id + "</h2>")
    			.append("<h2>pass정보: " + pass + "</h2>")
    			.append("<h2>점심메뉴: " + lunch + "</h2>")
    			.append("<h2>getRealPath: " + path + "</h2>");
    	
    	
    	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("GetServlet init");
	}
	
	
}
