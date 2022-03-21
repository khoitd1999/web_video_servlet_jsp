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

import com.laptrinhweb.Service.ICategoryService;
import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.utils.SessionUtil;
@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<CategoryModel> cate = categoryService.findAll();
			CategoryModel tmp = new CategoryModel();
			tmp.setListResult(cate);
			SessionUtil.getInstance().putValue(request, SystemConstant.CATEGORY, tmp);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
