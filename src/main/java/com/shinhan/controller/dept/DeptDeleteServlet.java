package com.shinhan.controller.dept;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.dept.DeptService;

@WebServlet("/dept/deptdelete")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int deptid = convertInt(request.getParameter("deptid"));
    	DeptService deptService = new DeptService();
    	int result = deptService.deleteDept(deptid);
		
    	request.setAttribute("resultMessage", result>0?"삭제성공":"삭제실패");
		request.getRequestDispatcher("deptresult.jsp").forward(request, response);
	}
    
    //한꺼번에 여러 건 삭제하기
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String[] arr = request.getParameterValues("del");
    	//System.out.println(Arrays.toString(arr));
    	
    	DeptService deptService = new DeptService();
    	for(String s_deptid : arr) {
    		int deptid = convertInt(s_deptid);
    		int result = deptService.deleteDept(deptid);
    	}
    	
    	response.sendRedirect("deptlist");
    	
    	
	}

	private int convertInt(String data) {
		if(data == null || data.equals("")) return 0;
		return Integer.parseInt(data);
	}
	
}
