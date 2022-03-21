package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.util.Collections;
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
import com.laptrinhweb.Service.ICommentService;
import com.laptrinhweb.Service.IUsersService;
import com.laptrinhweb.Service.IVideoService;
import com.laptrinhweb.model.CommentModel;
import com.laptrinhweb.model.UsersModel;
import com.laptrinhweb.model.VideosModel;

@WebServlet(urlPatterns = ("/chi-tiet-video"))
public class ChiTietVideo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IVideoService videoService;
	
	@Inject
	private ICommentService commentService;
	
	@Inject
	private IUsersService userService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idV = request.getParameter("idV");
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");

		if(StringUtils.isNotBlank(message)) {
			Message me = new Message(message);
			request.setAttribute("message", me.getMessage());
			request.setAttribute("alert", alert);
		}
		VideosModel video = videoService.findOne(Long.parseLong(idV));
		List<CommentModel> comment = commentService.findAllByVideo(Long.parseLong(idV));
		for (int i=0 ; i < comment.size() ; i++) {
			UsersModel user = userService.findOne(comment.get(i).getIdU());
			comment.get(i).setUsername(user.getFullname());
		}
		Collections.reverse(comment);
		request.setAttribute("comment", comment);
		request.setAttribute("video", video);
		request.setAttribute("index", 0);
		RequestDispatcher rd = request.getRequestDispatcher("views/web/ChiTietVideo.jsp");
		rd.forward(request, response);
	}
}
