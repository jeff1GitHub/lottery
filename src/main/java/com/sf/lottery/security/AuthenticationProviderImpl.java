package com.sf.lottery.security;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.sf.lottery.entity.User;
import com.sf.lottery.security.exception.LoginErrorException;
import com.sf.lottery.security.exception.PasswordErrorException;
import com.sf.lottery.service.IUserService;
import com.sf.lottery.utils.Tools;

/**
 * 身份认证验证组件
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
	@Resource
	private IUserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 获取认证的用户名 & 密码
		String acc = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		User user;
		try {
			user = userService.login(acc, Tools.MD5(acc + pwd));
		} catch (Exception e) {
			throw new LoginErrorException("user login error.", e);
		}

		// 认证逻辑
		if (user == null) {
			throw new PasswordErrorException();
		} else {
			// 这里设置权限和角色
			ArrayList<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			authorities.add(new GrantedAuthorityImpl("AUTH_WRITE"));
			// 生成令牌
			Authentication auth = new UsernamePasswordAuthenticationToken(acc, pwd, authorities);
			return auth;
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {// 是否可以提供输入类型的认证服务
		return clazz.equals(UsernamePasswordAuthenticationToken.class);
	}

}
