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

/**
 * 모든 요청은 EncodingFilter를 수행한다.
 * filter는 서버시작 시 생성, init
 * filter는 서버중지시 소멸된다.
 */
//@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
       
    public EncodingFilter() {
        //System.out.println("EncodingFilter 생성자");
    }

	public void destroy() {
		//System.out.println("EncodingFilter destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		//=================================================================================
		//doFilter() 위쪽의 코드 : 요청 Filter
		
		request.setCharacterEncoding("utf-8");
		
		
		//---------------------------------------------------------------------------------
		chain.doFilter(request, response);	//나의 요청으로 간다. 또다른 filter가 있으면 filter로 간다.
		//---------------------------------------------------------------------------------
		//doFilter() 아래의 코드 : 응답 Filter
		
		
		
		
		//=================================================================================
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("EncodingFilter init");
	}

}
