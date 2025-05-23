package com.shinhan.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.emp.EmpDTO;
import com.shinhan.model.emp.EmpService;

/*
 * 405 - 허용되지 않는 메소드, 요청한 메소드가 정의되지 않음
 * 404 - 요청한 주소의 Mapping이 없음
 * 서버시작오류? 서버시작시 web.xml 실행 @WebServlet 실행 오류발생하면 서버시작안됨
 */
@WebServlet({ "/auth/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		/* URL pattern 연습 */
		String cpath = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String address = request.getRemoteAddr();
		
		System.out.println("cpath: " + cpath);	/* /appleShop */
		System.out.println("url: " + url);		/* http://localhost:9090/appleShop/auth/login */
		System.out.println("mapping: " + mapping);	/* /auth/login */
		System.out.println("uri: " + uri);		/* /appleShop/auth/login */
		System.out.println("method: " + method);	/* GET */
		System.out.println("address: " + address);	/* 서버에 접속한 client의 IP */
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	
	//get요청으로 한글이 넘어오면 자동으로 encoding, decoding이 된다.(깨짐 없음)
	//post는 요청문서의 body로 넘어온다. encoding 없음(깨짐 발생)
    protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
    	
    	String u_id = request.getParameter("userid");
    	String u_pwd = request.getParameter("pswd");
    	String remember = request.getParameter("remember");
    	
    	//로그인체크 ... empoloyees => userid(employee_id), pswd(email)
    	int empid = Integer.parseInt(u_id.equals("")?"0":u_id);
    	EmpService empService = new EmpService();
    	EmpDTO emp = empService.selectById(empid);
    	
    	if(emp == null) {
    		System.out.println("존재하지 않는 사용자");
    		response.sendRedirect("login");
    		return;
    	} else if(!emp.getEmail().equals(u_pwd)) {
    		System.out.println("비밀번호 오류");
    		response.sendRedirect("login");
    		return;
    	} else {
    		System.out.println("로그인 성공");
    		HttpSession session = request.getSession();	//true: 세션이 존재(접속기록 o)하면 세션을 얻고, 없으면 새로 생성
    		session.setMaxInactiveInterval(60 * 60 * 24);//하루 동안 유효
    		session.setAttribute("loginEmp", emp);
    	}
    	
    	//직원조회로 가기 (절대경로 : http://localhost:9090/)
    	String cpath = getServletContext().getContextPath();	// /appleShop
    	response.sendRedirect(cpath + "/emp/emplist.do");
    	
    	
    	
    	
    	
    	
    	
    	
    	/*
    	
    	String[] arr = request.getParameterValues("subject");
    	
    	Enumeration<String> names = request.getParameterNames();
    	while(names.hasMoreElements()) {
    		String param = names.nextElement();
    		if(param.equals("subject")) {
    			String[] data = request.getParameterValues(param);
    			System.out.println("data=> " + Arrays.toString(data));
    		} else {
    			String data = request.getParameter(param);
    			System.out.println("data=> " + data);
    		}
    		
    	}
    	
    	System.out.println("===================================");
    	System.out.println("u_id: " + u_id);
    	System.out.println("u_pwd: " + u_pwd);
    	System.out.println("remember: " + remember);
    	System.out.println("subject배열: " + Arrays.toString(arr));
		*/
		
    	//MVC2모델을 Servlet과 JSP가 함께 각자 담당 구현
    	//Servlet = JAVA(O) + HTML
    	//JSP = JAVA + HTML(X)
    	
    	//응답문서를 설정하고 만들기 (주의 : 설정 후 문서만들기가 되어야한다)
		/*
		 * response.setContentType("text/html;charset=utf-8"); //응답문서 생성 이전에 설정해야 안깨짐!
		 * PrintWriter out = response.getWriter(); out.print("<h1>응답문서</h1>");
		 * out.print("<h1>path:" + request.getContextPath() + "</h1>");
		 * out.print("<h1>접속한 client: " + request.getRemoteAddr() + "</h1>");
		 */
    	
    	//응답문서는 하나밖에 못 만들음
    	/* response.getWriter().append("Served at: ").append(request.getContextPath()); */
		//response : 응답문서, contextPath : appleShop
	}
}
