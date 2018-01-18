package com.sf.lottery.security;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Token工具类
 */
public class TokenAuthenticationService {
	/** 有效期(5天) */
	private static final long EXPIRATION_TIME = 432_000_000;
	/** JWT密码 */
	private static final String SECRET = "P@ssw02d";
	/** Token前缀 */
	private static final String TOKEN_PREFIX = "Bearer";
	/** 存放Token的Header中的Key */
	private static final String HEADER_STRING = "Authorization";

	/**
	 * 生成JWT并写入到Body
	 * @param response
	 * @param userName
	 */
	public static String addAuthentication(HttpServletResponse response, String userName) {
		// 生成JWT
		final String JWT = Jwts.builder()
				// 保存权限（角色）
				.claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
				// 用户名写入标题
				.setSubject(userName)
				// 有效期设置
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				// 签名设置
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		return JWT;
	}

	/**
	 * 验证Head中的JWT并生成验证令牌
	 * @param request
	 * @return Authentication 验证令牌
	 */
	public static Authentication getAuthentication(HttpServletRequest request) {
		// 从Header中拿到token
		String token = request.getHeader(HEADER_STRING);
		if (token == null) {
			return null;
		} else {
			// 解析 Token
			JwtParser parser = Jwts.parser();
			// 验签
			parser.setSigningKey(SECRET);
			// 去掉 Bearer
			Claims claims = parser.parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();

			// 拿用户名
			String user = claims.getSubject();

			// 得到 权限（角色）
			List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));

			// 返回验证令牌
			return user == null ? null : new UsernamePasswordAuthenticationToken(user, null, authorities);
		}
	}
}
