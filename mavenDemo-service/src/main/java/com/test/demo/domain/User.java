package com.test.demo.domain;

public class User {
	long id;
	String name;
	String address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String toString() {
		String str = id+ "," + name + "," + address;
		return str;
	}
}
