package com.laptrinhweb.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T mapper(ResultSet rs);
}
