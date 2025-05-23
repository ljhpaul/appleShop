package com.shinhan.controller.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.dept.DeptDTO;
import com.shinhan.model.dept.DeptService;

@WebServlet("/dept/deptdetail")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int s_deptid = convertInt(request.getParameter("deptid"));
    	DeptService deptService = new DeptService();
    	DeptDTO dept = deptService.selectById(s_deptid);
		
    	request.setAttribute("dept", dept);
    	request.getRequestDispatcher("deptdetail.jsp")
    						.forward(request, response);
	}

	@Override
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
			
		//DB에 update 서비스를 호출
		DeptService deptService = new DeptService();
		int result = deptService.updateDept(dept);
		
		request.setAttribute("resultMessage", result>0?"수정성공":"수정실패");
		request.getRequestDispatcher("deptresult.jsp").forward(request, response);
		
	}

	private int convertInt(String data) {
		if(data == null || data.equals("")) return 0;
		return Integer.parseInt(data);
	}
	
}
