package com.laptrinhweb.Service;

import java.util.List;

import com.laptrinhweb.model.UsersModel;

public interface IUsersService {
	UsersModel findByUsernameAndPassword(String name,String password);
	UsersModel findOne(Long idU);
	List<UsersModel> findAllByIdR(Long idR);
	void delete(Long[] idU);
	UsersModel insert(UsersModel user);
}
