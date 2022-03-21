package com.laptrinhweb.DAO.impl;

import java.util.List;

import com.laptrinhweb.DAO.IUsersDAO;
import com.laptrinhweb.mapper.UsersMapper;
import com.laptrinhweb.model.UsersModel;

public class UsersDAO extends AbstractDAO<UsersModel> implements IUsersDAO{

	public UsersModel findByUserNameAndPassword(String name, String password) {
		String sql = "select * from users where username = ? and password = ?";
		List<UsersModel> user = query(sql, new UsersMapper(), name, password);
		return user.isEmpty() ? null : user.get(0);
	}

	public UsersModel findOne(Long idU) {
		String sql = "select * from users where idU = ?";
		List<UsersModel> user = query(sql, new UsersMapper(), idU);
		return user.isEmpty() ? null : user.get(0);
	}

	public List<UsersModel> findAllByIdR(Long idR) {
		String sql = "select * from users where idR = ?";
		return query(sql, new UsersMapper(), idR);
	}

	public void delete(Long idU) {
		String sql = "delete from users where idU = ?";
		update(sql, idU);
	}

	public Long insert(UsersModel user) {
		StringBuilder sql = new StringBuilder("insert into users (username,password,fullname,createdDate,createdBy,idR)");
		sql.append(" values(?,?,?,?,?,?)"); 
		return insert(sql.toString(), user.getUsername(), user.getPassword(), user.getFullname()
				,user.getCreatedDate(),user.getCreatedBy(),user.getIdR());
	}

}
