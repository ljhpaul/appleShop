package com.shinhan.controller.emp;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.common.util.DateUtil;
import com.shinhan.model.dept.DeptDTO;
import com.shinhan.model.dept.DeptService;
import com.shinhan.model.emp.EmpDTO;
import com.shinhan.model.emp.EmpService;
import com.shinhan.model.job.JobDAO;
import com.shinhan.model.job.JobDTO;

@WebServlet("/emp/empinsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpService empService = new EmpService();
		DeptService deptService = new DeptService();
		JobDAO jobDAO = new JobDAO();
		
		List<EmpDTO> emplist = empService.selectAll();
		List<DeptDTO> deptlist = deptService.selectAll();
		List<JobDTO> joblist = jobDAO.getAllJobs();
		
		request.setAttribute("emplist", emplist);
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);
		
		request.getRequestDispatcher("empinsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 한글 인코딩
//		request.setCharacterEncoding("utf-8");

		int employee_id = convertInt(request.getParameter("employee_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		Date hire_date = convertDate(request.getParameter("hire_date"));
		String job_id = request.getParameter("job_id");
		double salary = convertDouble(request.getParameter("salary"));
		double commission_pct = convertDouble(request.getParameter("commission_pct"));
		int manager_id = convertInt(request.getParameter("manager_id"));
		int department_id = convertInt(request.getParameter("department_id"));
		
		EmpDTO emp = EmpDTO.builder()
						   .employee_id(employee_id)
						   .first_name(first_name)
						   .last_name(last_name)
						   .email(email)
						   .phone_number(phone_number)
						   .hire_date(hire_date)
						   .job_id(job_id)
						   .salary(salary)
						   .commission_pct(commission_pct)
						   .manager_id(manager_id)
						   .department_id(department_id)
						   .build();
		
		EmpService empService = new EmpService();
		int result = empService.insertEmp(emp);
		
		request.setAttribute("resultMessage", result>0?"입력성공":"입력실패");
		request.getRequestDispatcher("empresult.jsp").forward(request, response);
		
	}

	private int convertInt(String parameter) {
		if(parameter == null || parameter.equals("")) return 0;
		return Integer.parseInt(parameter);
	}
	
	private double convertDouble(String parameter) {
		if(parameter == null || parameter.equals("")) return 0;
		return Double.parseDouble(parameter);
	}
	
	private java.sql.Date convertDate(String parameter) {
		if(parameter == null || parameter.equals("")) return null;
		return DateUtil.convertToSQLDate(DateUtil.ConvertToDate(parameter));
	}
	
}