package com.sf.lottery.vo;

/**
 * 用户登录结果
 */
public class UserLoginResult {
	/** 名称 */
	private String name;
	/** 令牌 */
	private String token;
	
	public UserLoginResult(String name, String token) {
		this.name = name;
		this.token = token;
	}

	public String getName() {
		return name;
	}
	
	public String getToken() {
		return token;
	}
	
}
