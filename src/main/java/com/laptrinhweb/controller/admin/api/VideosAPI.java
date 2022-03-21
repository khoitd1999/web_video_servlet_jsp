package com.laptrinhweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.Service.IVideoService;
import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.UsersModel;
import com.laptrinhweb.model.VideosModel;
import com.laptrinhweb.utils.HttpUtils;
import com.laptrinhweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-videos"})
public class VideosAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IVideoService videoService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper object = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		VideosModel video = HttpUtils.StringJson(request.getReader()).toModel(VideosModel.class);
		UsersModel tmp = (UsersModel) SessionUtil.getInstance().getValue(request, SystemConstant.MODEL);
		
		video.setCreatedBy(tmp.getUsername());
		video = videoService.insert(video);
		object.writeValue(response.getOutputStream(), video);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper object = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		VideosModel video = HttpUtils.StringJson(request.getReader()).toModel(VideosModel.class);
		video = videoService.update(video);
		object.writeValue(response.getOutputStream(), video);
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper object = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		VideosModel video = HttpUtils.StringJson(request.getReader()).toModel(VideosModel.class);
		videoService.delete(video.getIds());
		object.writeValue(response.getOutputStream(), "");
	}
}
