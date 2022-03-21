package com.laptrinhweb.model;

public class CategoryModel extends AbstractModel<CategoryModel>{
	private Long idCate;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdCate() {
		return idCate;
	}
	public void setIdCate(Long idCate) {
		this.idCate = idCate;
	}
}
