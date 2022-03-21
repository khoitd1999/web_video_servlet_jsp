package com.laptrinhweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.laptrinhweb.Alert.Message;
import com.laptrinhweb.Service.IUsersService;
import com.laptrinhweb.model.UsersModel;

@WebServlet(urlPatterns = ("/admin-user"))

public class UserController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IUsersService userService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idR = request.getParameter("idR");
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if (StringUtils.isNotBlank(message)) {
			Message me = new Message(message);
			request.setAttribute("message", me.getMessage());
			request.setAttribute("alert", alert);
		}
		List<UsersModel> user = userService.findAllByIdR(Long.parseLong(idR));
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/tableUser.jsp");
		rd.forward(request, response);
	}
}
