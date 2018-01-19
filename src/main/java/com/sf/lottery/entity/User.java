package com.sf.lottery.entity;

import java.sql.Timestamp;

public class User {
	private long id;
	private String name;
	private String pwd;
	private Timestamp createTime;

	public User(long id, String name, String pwd, Timestamp createTime) {
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

	public Timestamp getCreateTime() {
		return createTime;
	}

}
