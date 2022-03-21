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
import com.laptrinhweb.Service.ICategoryService;
import com.laptrinhweb.Service.IVideoService;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.VideosModel;

@WebServlet(urlPatterns = {"/admin-video"})
public class VideoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IVideoService videoService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		String type = request.getParameter("type");
		String idCate = request.getParameter("idCate");
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if (StringUtils.isNotBlank(message)) {
			Message me = new Message(message);
			request.setAttribute("message", me.getMessage());
			request.setAttribute("alert", alert);
		}
		if(type.equals("list")) {
			CategoryModel cate = categoryService.findOne(Long.parseLong(idCate));
			List<VideosModel> video = new ArrayList<VideosModel>();
			video = videoService.findByCategory(Long.parseLong(idCate));
			VideosModel tmp = new VideosModel();
			tmp.setListResult(video);
			request.setAttribute("arrayVideo", tmp);
			request.setAttribute("tenCate", cate);
			view = "/views/admin/table.jsp";
		}else if(type.equals("edit")) {
			String idV = request.getParameter("idV");
			if (StringUtils.isNotBlank(idV)) {
				VideosModel video = videoService.findOne(Long.parseLong(idV));
				CategoryModel videoCate = categoryService.findOne(video.getIdCate());
				request.setAttribute("video", video);
				request.setAttribute("videoCate", videoCate);
			}
			view = "/views/admin/edit.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
