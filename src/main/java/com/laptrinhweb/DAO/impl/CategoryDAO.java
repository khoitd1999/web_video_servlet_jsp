package com.laptrinhweb.DAO.impl;

import java.util.List;

import com.laptrinhweb.DAO.ICategoryDAO;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	public CategoryModel findOne(Long idCate) {
		String sql = "select * from category where idCate = ?";
		List<CategoryModel> cate = query(sql, new CategoryMapper(), idCate);
		return cate.isEmpty() ? null : cate.get(0);
	}

}
