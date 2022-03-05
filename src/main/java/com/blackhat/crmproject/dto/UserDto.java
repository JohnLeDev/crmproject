package com.blackhat.crmproject.dto;

public class UserDto {
	private int id;
	private String email;
	private String password;
	private String fullname;
	private int roleId;
	private String phone; // Kha them 3/2/2022
	private String address;
	/*
	private String avatar;
	private String roleDesc;
	*/
	
	public UserDto() {}
	
	public UserDto(int id, String email, String password, String fullname, int roleId, String phone, String address) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleId = roleId;
		this.phone = phone;
		this.address = address;
	}


	
	
	/*public UserDto(String email, String password, String fullname, int roleId) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleId = roleId;
	}

	public UserDto(int id, String email, String password, String fullname, int roleId) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleId = roleId;
	}
	public UserDto(int id, String email, String password, String fullname, int roleId,String roleDesc) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}
	*/
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
}


	
