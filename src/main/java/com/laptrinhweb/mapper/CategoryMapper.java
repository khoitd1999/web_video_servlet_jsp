package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	public CategoryModel mapper(ResultSet rs) {
		CategoryModel cate = new CategoryModel();
		try {
			cate.setIdCate(rs.getLong("idCate"));
			cate.setName(rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cate;
	}

}
