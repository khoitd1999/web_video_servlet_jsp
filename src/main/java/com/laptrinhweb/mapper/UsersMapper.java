package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.UsersModel;

public class UsersMapper implements RowMapper<UsersModel>{

	public UsersModel mapper(ResultSet rs) {
		UsersModel user = new UsersModel();
		try {
			user.setIdU(rs.getLong("idU"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setCreatedDate(rs.getDate("createdDate"));
			user.setCreatedBy(rs.getString("createdBy"));
			user.setFullname(rs.getString("fullname"));
			user.setIdR(rs.getLong("idR"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
