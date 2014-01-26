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

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		
		String header = request.getHeader("Referer");
		StringBuffer requestURL = request.getRequestURL();
		String queryString = request.getQueryString();
		String scheme = request.getScheme();
//		System.out.println(header);
//		System.out.println(queryString);
//		System.out.println(requestURL.toString());
//		System.out.println(scheme);
//		response.getOutputStream().write("write......".getBytes());
		arg2.doFilter(request, response);//放行
//		System.out.println("...........");
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
