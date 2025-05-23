package com.shinhan.controller.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.emp.EmpService;

@WebServlet("/emp/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpService empService = new EmpService();
		int empid = convertInt(request.getParameter("empid"));
		
		int result = empService.deleteByEmpId(empid);
		
		request.setAttribute("resultMessage", empid + "번 직원 " + (result>0?"삭제성공":"삭제실패"));
		
		//요청 재지정하기
//		response.sendRedirect("emplist.do");
		
		request.getRequestDispatcher("empresult.jsp").forward(request, response);
		
	}

	private int convertInt(String parameter) {
		if(parameter == null || parameter.equals("")) return 0;
		return Integer.parseInt(parameter);
	}
	
	
}
