package com.laptrinhweb.model;

public class UsersModel extends AbstractModel<UsersModel>{
	private Long idU;
	private String username;
	private String password;
	private String fullname;
	private Long idR;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Long getIdR() {
		return idR;
	}
	public void setIdR(Long idR) {
		this.idR = idR;
	}
	public Long getIdU() {
		return idU;
	}
	public void setIdU(Long idU) {
		this.idU = idU;
	}

}
