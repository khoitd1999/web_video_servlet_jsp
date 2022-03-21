package com.laptrinhweb.DAO;

import java.util.List;

import com.laptrinhweb.model.UsersModel;

public interface IUsersDAO {
	UsersModel findByUserNameAndPassword(String name,String password);
	UsersModel findOne(Long idU);
	List<UsersModel> findAllByIdR(Long idR);
	void delete(Long idU);
	Long insert(UsersModel user);
}
