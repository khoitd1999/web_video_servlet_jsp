package com.laptrinhweb.Service.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.DAO.IUsersDAO;
import com.laptrinhweb.Service.IUsersService;
import com.laptrinhweb.model.UsersModel;

public class UsersService implements IUsersService{
	
	@Inject
	private IUsersDAO usersDAO;

	public UsersModel findByUsernameAndPassword(String name, String password) {
		return usersDAO.findByUserNameAndPassword(name, password);
	}

	public UsersModel findOne(Long idU) {
		return usersDAO.findOne(idU);
	}

	public List<UsersModel> findAllByIdR(Long idR) {
		return usersDAO.findAllByIdR(idR);
	}

	public void delete(Long[] idU) {
		for (Long id : idU) {
			usersDAO.delete(id);
		}
	}

	public UsersModel insert(UsersModel user) {
		user.setCreatedDate(new Date(System.currentTimeMillis()));
		user.setCreatedBy(user.getUsername());
		Long idU = usersDAO.insert(user);
		return usersDAO.findOne(idU);
	}
}
