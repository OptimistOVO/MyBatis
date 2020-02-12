package com.bjsxt.bean;

import java.io.Serializable;

public class User implements Serializable{
	private String username;
	private String password;
	private int id;
	
	public User() {
	
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
