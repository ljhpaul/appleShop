package com.shinhan.controller.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.dept.DeptDTO;
import com.shinhan.model.dept.DeptService;

@WebServlet("/dept/deptlist")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	DeptService deptService = new DeptService();
    	List<DeptDTO> deptlist = deptService.selectAll();
    	
    	//요청객체에 조회된 내용을 저장한다.
    	request.setAttribute("deptListData", deptlist);
    	request.setAttribute("myName", "jeongheon");
    	
    	request.getRequestDispatcher("deptlist.jsp")
    					.forward(request, response);	//(jsp->servlet)위임
		
    	//Servlet : 자바담당, HTML tag 사용하는 것은 바람직하지않다.
    	//JSP : HTML 담당, JSP에서 JAVA코드를 사용하지 않는 것이 바람직하다.
    	//해결 ==> 응답은 서블릿이 받아 자바코드를 수행하고, 결과는 JSP에 위임하여 응답한다.
		/*
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().append("Served at: ")
				.append(deptlist.size() + "건")
				.append(deptlist.toString())
				.append(request.getContextPath());
		*/
	}
}
