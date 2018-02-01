package com.sf.lottery.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.sf.lottery.common.Context;

public class ServerFilter extends FilterSecurityInterceptor {
	private RequestMatcher requiresAuthenticationRequestMatcher;
	private Context serverContext;
	
	public ServerFilter(Context serverContext, String url, AuthenticationManager authManager) {
		this.serverContext = serverContext;
		requiresAuthenticationRequestMatcher = new AntPathRequestMatcher(url);
		super.setAuthenticationManager(authManager);
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(!requiresAuthentication(req, res)){
			chain.doFilter(request, response);
			return;
		}
		
		if(serverContext.isOpen()){
			chain.doFilter(req, res);
		}else{
			response.setContentType("application/json;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				out.print("{\"code\": \"260\", \"message\": \"服务器维护中...\"}");
				out.flush();
			}
		}
	}
	
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		return requiresAuthenticationRequestMatcher.matches(request);
	}
	
}
