package com.laptrinhweb.model;

public class RoleModel extends AbstractModel<RoleModel>{
	private Long idR;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdR() {
		return idR;
	}
	public void setIdR(Long idR) {
		this.idR = idR;
	}
}
