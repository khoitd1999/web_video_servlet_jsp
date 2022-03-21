package com.laptrinhweb.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.Service.IUsersService;
import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.UsersModel;
import com.laptrinhweb.utils.HttpUtils;
import com.laptrinhweb.utils.SessionUtil;

@WebServlet(urlPatterns = ("/api-user"))
public class UserAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUsersService userService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper object = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UsersModel userTao = HttpUtils.StringJson(request.getReader()).toModel(UsersModel.class);
		List<UsersModel> user = userService.findAllByIdR(userTao.getIdR());
		Boolean isInsert = true;
		for (int i = 0 ; i < user.size() ; i++) {
			if(user.get(i).getUsername().equals(userTao.getUsername())){
				isInsert = false;
				break;
			}
		}
		if(isInsert) {
			userTao = userService.insert(userTao);
			object.writeValue(response.getOutputStream(), "");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper object = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UsersModel userXoa = HttpUtils.StringJson(request.getReader()).toModel(UsersModel.class);
		UsersModel userCurrent = (UsersModel) SessionUtil.getInstance().getValue(request, SystemConstant.MODEL);
		Boolean isDelete = true;
		for(int i=0 ; i < userXoa.getIds().length ;i++) {
			if(userCurrent.getIdU().equals(userXoa.getIds()[i])) {
				isDelete = false;
				break;
			}
		}
		if(isDelete) {
			userService.delete(userXoa.getIds());
			object.writeValue(response.getOutputStream(), "");
		}
	}
}
