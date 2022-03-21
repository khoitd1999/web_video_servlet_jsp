package com.laptrinhweb.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = ("/admin-comment"))
public class CommentController extends HttpServlet{

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
		String idU = request.getParameter("idU");
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		VideosModel video = new VideosModel();
		UsersModel user = new UsersModel();
		List<CommentModel> comment = new ArrayList<CommentModel>();
		
		if (StringUtils.isNotBlank(message)) {
			Message me = new Message(message);
			request.setAttribute("message", me.getMessage());
			request.setAttribute("alert", alert);
		}
		
		if(StringUtils.isNotBlank(idV)) {
			video = videoService.findOne(Long.parseLong(idV));
			comment = commentService.findAllByVideo(Long.parseLong(idV));
			for (int i=0 ; i < comment.size() ;i++) {
				user = userService.findOne(comment.get(i).getIdU());
				comment.get(i).setUsername(user.getUsername());
			}
			request.setAttribute("video", video);
		} else if(StringUtils.isNotBlank(idU)) {
			user = userService.findOne(Long.parseLong(idU));
			comment = commentService.findAllByUser(Long.parseLong(idU));
			for (int i=0 ; i < comment.size() ;i++) {
				video = videoService.findOne(comment.get(i).getIdV());
				comment.get(i).setTitle(video.getTitle());
			}
			request.setAttribute("user", user);
		}
		request.setAttribute("comment", comment);
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/tableComment.jsp");
		rd.forward(request, response);
	}

}
