package com.sf.lottery.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.sf.lottery.common.Context;

@Component
public class ServerFilter implements Filter {
	@Resource
	private Context serverContext;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String requestUrl = req.getRequestURI().replaceFirst(req.getContextPath(), "");
		if(requestUrl.startsWith("/lottery/")){
			if(!serverContext.isOpen()){
				response.setContentType("application/json;charset=UTF-8");
				try (PrintWriter out = response.getWriter()) {
					out.print("{\"code\": \"260\", \"message\": \"服务器维护中...\"}");
					out.flush();
				}
				return;
			}
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

	}

}
