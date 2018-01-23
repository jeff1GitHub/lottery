package com.sf.lottery.entity;

import java.util.Date;

public class User {
	private long id;
	private String name;
	private String pwd;
	private Date createTime;
	
	public User() {}

	public User(long id, String name, String pwd, Date createTime) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public Date getCreateTime() {
		return createTime;
	}

}
