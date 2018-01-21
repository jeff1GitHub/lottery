package com.sf.lottery.security;

public class AccountCredentials {
	private String username;
	private String password;
	private AccountEnum accountEnum;
	
	public enum AccountEnum {
		/** 普通用户 */
		USER,
		/** 管理员 */
		ADMIN
	}

	public AccountCredentials(String username, String password, AccountEnum accountEnum) {
		this.username = username;
		this.password = password;
		this.accountEnum = accountEnum;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public AccountEnum getAccountEnum() {
		return accountEnum;
	}
	
}
