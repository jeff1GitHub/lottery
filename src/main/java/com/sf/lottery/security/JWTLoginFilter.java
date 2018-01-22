package com.sf.lottery.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sf.lottery.security.exception.LoginErrorException;
import com.sf.lottery.security.exception.PasswordErrorException;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.utils.Tools;
import com.sf.lottery.vo.AccountVo;

/**
 * 拦截用户登录请求
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	private final Logger logger = LoggerFactory.getLogger(JWTLoginFilter.class);

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
		//登录时需要验证时候调用
		String acc = req.getParameter("acc");
		String pwd = req.getParameter("pwd");
		String type = req.getParameter("type");
		AccountCredentials.AccountEnum accountType;
		try {
			accountType = type == null ? null : AccountCredentials.AccountEnum.valueOf(type);
		} catch (Exception e) {
			logger.error("account type parameter error.", e);
			accountType = null;
		}
		
		// JSON反序列化成 AccountCredentials
		//new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
		AccountCredentials creds = new AccountCredentials(acc, pwd, accountType);
		
		// 返回一个验证令牌
		Authentication authentication = new UsernamePasswordAuthenticationToken(creds, creds.getPassword());
		authentication = getAuthenticationManager().authenticate(authentication);
		return authentication;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
		String userName = auth.getName();
		
		//验证成功后调用
		String JWT = TokenAuthenticationService.addAuthentication(auth, userName);
		
		AccountVo vo = new AccountVo(userName, JWT);
		JsonResult<AccountVo> result = new JsonResult<>(ResultCode.SUCCESS, vo);
		String msg = Tools.getJsonString(result);
		
		res.setContentType("application/json;charset=UTF-8");
		res.setStatus(HttpServletResponse.SC_OK);
		res.getWriter().println(msg);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res, AuthenticationException exc) throws IOException, ServletException {
		//验证失败后调用，这里直接灌入500错误返回，由于同一JSON返回，HTTP就都返回200了
		JsonResult<String> result;
		if(exc instanceof PasswordErrorException){
			result = new JsonResult<>(ResultCode.PARAMS_ERROR, "登录失败，帐号或密码错误!");
		}else if(exc instanceof LoginErrorException){
			logger.error("", exc);
			result = new JsonResult<>(ResultCode.PARAMS_ERROR, "登录失败，帐号或密码错误!");
		}else{
			logger.error("", exc);
			result = new JsonResult<>(ResultCode.UNKNOWN_ERROR);
		}
		
		res.setContentType("application/json;charset=UTF-8");
		res.setStatus(HttpServletResponse.SC_OK);
		String msg = Tools.getJsonString(result);
		res.getWriter().println(msg);
	}

}
