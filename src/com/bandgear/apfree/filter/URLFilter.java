package com.bandgear.apfree.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class URLFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		String header = request.getHeader("Referer");
		StringBuffer requestURL = request.getRequestURL();
		String queryString = request.getQueryString();
		String scheme = request.getScheme();
//		System.out.println("user-agent====="+request.getHeader("user-agent"));
		chain.doFilter(request, response);//放行
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
