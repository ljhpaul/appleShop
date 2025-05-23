package com.shinhan.controller.dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.dept.DeptDTO;
import com.shinhan.model.dept.DeptService;

@WebServlet("/dept/deptinsert")
public class DeptInsertServlet extends HttpServlet {
	/* private static final long serialVersionUID = 1L; */
	
	//입력창보이기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//jsp에 위임
		request.getRequestDispatcher("deptinsert.jsp")
			   .forward(request, response);
	}
	
	//DB에 insert
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post는 한글있는 경우 반드시~~
//		request.setCharacterEncoding("utf-8");
		
		String s_job = request.getParameter("job");
		int deptid = convertInt(request.getParameter("department_id"));
		String deptname = request.getParameter("department_name");
		int managerId = convertInt(request.getParameter("manager_id"));
		int locationId = convertInt(request.getParameter("location_id"));
		
		DeptDTO dept = DeptDTO.builder()
					   .department_id(deptid)
					   .department_name(deptname)
					   .manager_id(managerId)
					   .location_id(locationId)
					   .build();
		
		System.out.println(s_job + " : " + dept);
		
		//DB에 insert 서비스를 호출
		DeptService deptService = new DeptService();
		int result = deptService.insertDept(dept);
		
		request.setAttribute("resultMessage", result>0?"입력성공":"입력실패");
		request.getRequestDispatcher("deptresult.jsp").forward(request, response);
		
		/*
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<meta http-equiv=\"Refresh\" content=\"3;url=deptlist\">");
		out.print("<h1>" + (result>0?"입력성공":"입력실패") + "</h1>");
		out.print("<a href='deptlist'>목록보기</a>");
		*/
	}

	private int convertInt(String parameter) {
		if(parameter == null || parameter.equals("")) return 0;
		return Integer.parseInt(parameter);
	}

}
