package com.laptrinhweb.controller.web;

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
import com.laptrinhweb.Service.IUsersService;
import com.laptrinhweb.Service.IVideoService;
import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.UsersModel;
import com.laptrinhweb.model.VideosModel;
import com.laptrinhweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/dang-xuat","/dang-ki"})
public class HomeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IVideoService videoService;
	
	@Inject
	private IUsersService usersService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "";
		String action = request.getParameter("action");
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		List<CategoryModel> category = categoryService.findAll();
		SessionUtil.getInstance().putValue(request, "category", category);
		
		if(StringUtils.isNotBlank(message)) {
			Message me = new Message(message);
			request.setAttribute("message", me.getMessage());
			request.setAttribute("alert", alert);
		}
		
		if (action != null && action.equals("login")) {
			view = "/views/login.jsp";
		}
		else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, SystemConstant.MODEL);
			view = "/views/login.jsp";
		}else if (action != null && action.equals("register")) {
			String idR = request.getParameter("idR");
			request.setAttribute("idRole", idR);
			view = "/views/web/register.jsp";
		}else {
			List<VideosModel> videoByCate = new ArrayList<VideosModel>();
			for (int i=0 ; i < category.size() ;i++) {
				List<VideosModel> video = findVideosByCategory(category.get(i).getIdCate());
				VideosModel tmp = new VideosModel();
				// dùng title tạm thời thay cho tên category vì trong VideosModel không có nameCategory
				tmp.setTitle(category.get(i).getName());
				// dùng idV tạm thời thay cho tên IdCate 
				tmp.setIdV(category.get(i).getIdCate());
				tmp.setListResult(video);
				videoByCate.add(tmp);
			}
			request.setAttribute("videoByCategory", videoByCate);
			view = "/views/web/home.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private List<VideosModel> findVideosByCategory(Long idCate) {
		List<VideosModel> video = videoService.findByCategoryAndNumber(idCate,(long) 0,(long) 4);
		return video;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsersModel user = usersService.findByUsernameAndPassword(username, password);
		SessionUtil.getInstance().putValue(request, SystemConstant.MODEL, user);
		if(user!=null) {
			if(user.getIdR() == 1)
				response.sendRedirect("/admin-home");
			if(user.getIdR() == 2)
				response.sendRedirect("/trang-chu");
		}else {
			response.sendRedirect("/dang-nhap?action=login&message=login_invalid&alert=danger");
		}
	}
}
