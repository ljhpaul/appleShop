package com.shinhan.controller.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.dept.DeptDTO;
import com.shinhan.model.dept.DeptService;
import com.shinhan.model.emp.EmpDTO;
import com.shinhan.model.emp.EmpService;
import com.shinhan.model.job.JobDAO;
import com.shinhan.model.job.JobDTO;

@WebServlet("/emp/empdetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.비즈니스 로직
		EmpService empService = new EmpService();
		DeptService deptService = new DeptService();
		JobDAO jobDAO = new JobDAO();
		
		int s_empid = convertInt(request.getParameter("empid"));
		
		EmpDTO emp = empService.selectById(s_empid);
		List<DeptDTO> deptlist = deptService.selectAll();
		List<JobDTO> joblist = jobDAO.getAllJobs();
		
		/* data 바인딩
		 * 1.request : 요청->응답 후 사라짐
		 * 2.session : 브라우저에서 여러 요청을 하는 동안 유지, 브라우저 닫으면 사라짐
		 * 3.application : 서버가 종료되면 사라짐
		 * */
		request.setAttribute("emp", emp);
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);
		
		
		
		//2.JSP 할당
		request.getRequestDispatcher("empdetail.jsp").forward(request, response);
		
//		response.sendRedirect("emplist.do");
	}

	private int convertInt(String parameter) {
		if(parameter == null || parameter.equals("")) return 0;
		return Integer.parseInt(parameter);
	}

}
