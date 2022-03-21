package com.laptrinhweb.Service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.DAO.ICategoryDAO;
import com.laptrinhweb.Service.ICategoryService;
import com.laptrinhweb.model.CategoryModel;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	public CategoryModel findOne(Long idCate) {
		return categoryDAO.findOne(idCate);
	}

}
