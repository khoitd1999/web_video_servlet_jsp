package com.laptrinhweb.controller.admin.api;

import java.io.IOException;
import java.sql.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.Service.ICommentService;
import com.laptrinhweb.Service.IUsersService;
import com.laptrinhweb.model.CommentModel;
import com.laptrinhweb.model.UsersModel;
import com.laptrinhweb.utils.HttpUtils;

@WebServlet(urlPatterns = ("/api-comment"))
public class CommentAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICommentService commentService;
	
	@Inject
	private IUsersService userService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper object = new ObjectMapper();
		CommentModel comment = HttpUtils.StringJson(request.getReader()).toModel(CommentModel.class);
		UsersModel user = userService.findOne(comment.getIdU());
		comment.setCreatedDate(new Date(System.currentTimeMillis()));
		comment.setCreatedBy(user.getUsername());
		comment = commentService.insert(comment);
		comment.setUsername(user.getFullname());
		object.writeValue(response.getOutputStream(), comment);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper object = new ObjectMapper();
		CommentModel comment = HttpUtils.StringJson(request.getReader()).toModel(CommentModel.class);
		commentService.delete(comment.getIds());
		object.writeValue(response.getOutputStream(), "");
	}
}
