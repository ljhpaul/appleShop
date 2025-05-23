package com.shinhan.controller.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.emp.EmpService;

@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.클라이언트가 요청한 업무로직을 서비스를 통해 수행 (할 일 다함)
		EmpService empService = new EmpService();
		request.setAttribute("emplist", empService.selectAll());
		
		//2.JSP(View담당)에게 위임한다. (응답: 그림 그리기는 jsp가 할 예정)
		request.getRequestDispatcher("empAll.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
