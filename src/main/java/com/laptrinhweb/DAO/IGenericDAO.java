package com.laptrinhweb.DAO;

import java.util.List;

import com.laptrinhweb.mapper.RowMapper;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql ,RowMapper<T> row, Object...parameter);
	void update(String sql,Object...parameter);
	Long insert(String sql,Object...parameter);
}
