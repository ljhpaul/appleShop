package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
    
	public AuthFilter() {
		//System.out.println("AuthFilter 생성자");
	}
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	//====================================================================
    	/* 요청 filter */
    	
    	//로그인을 하지않은 사용자에게 제공하지 않는 서비스임
    	HttpServletRequest http_req = (HttpServletRequest) request;
    	HttpServletResponse http_res = (HttpServletResponse) response;
    	HttpSession session = http_req.getSession();
    	Object obj = session.getAttribute("loginEmp");
    	
    	//주소확인하여 로그인창은 Redirect되지 않도록 처리!
    	String[] arr = { "/login", "/deptinsert", "/images", ".css", ".js" };
    	String uri = http_req.getRequestURI();
    	System.out.println("요청주소 uri: " + uri);
    	boolean isCheck = true;
    	
    	for(String addr : arr) {
    		if(uri.contains(addr)) {
    			isCheck = false;
    			break;
    		}
    	}
    	
    	if(isCheck && obj == null) {
    		session.setAttribute("info", "로그인하지 않은 사용자에게 제공하지 않는 서비스입니다."); 
    		String cpath = getServletContext().getContextPath();
    		http_res.sendRedirect(cpath + "/auth/login");
    		return;
    	}
    	
    	//--------------------------------------------------------------------
		chain.doFilter(request, response);
		//--------------------------------------------------------------------
		/* 응답 filter */
		
		
		
		
		//====================================================================
	}
    
}
