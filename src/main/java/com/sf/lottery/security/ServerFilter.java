package com.sf.lottery.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sf.lottery.common.Context;

public class ServerFilter implements Filter {
	private Context serverContext;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		serverContext = (Context)context.getBean("context");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(serverContext.isOpen()){
			chain.doFilter(request, response);
		}else{
			response.setContentType("application/json;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				out.print("{\"code\": \"260\", \"message\": \"服务器维护中...\"}");
				out.flush();
			}
		}
	}
	
	@Override
	public void destroy() {

	}

}
