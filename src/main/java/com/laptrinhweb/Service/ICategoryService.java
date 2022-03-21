package com.laptrinhweb.Service;

import java.util.List;

import com.laptrinhweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long idCate);
}
