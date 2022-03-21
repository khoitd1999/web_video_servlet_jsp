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

import com.laptrinhweb.Service.IVideoService;
import com.laptrinhweb.model.VideosModel;

@WebServlet(urlPatterns = ("/chi-tiet-the-loai"))
public class ChiTietTheLoai extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IVideoService videoService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		String idCate = request.getParameter("idCate");
		int offset ,totalPage;
		List<Integer> soTrangShow;
		if(!StringUtils.isNotBlank(page) && !StringUtils.isNotBlank(limit)) {
			page = "1";
			limit = "5";
		}
		totalPage = soLuongTrang(limit, idCate);
		offset = ( (Integer.parseInt(page)-1) * Integer.parseInt(limit) );
		List<VideosModel> video = videoService.findByCategoryAndNumber(Long.parseLong(idCate),(long) offset,Long.parseLong(limit));
		soTrangShow = TrangShow(Integer.parseInt(page), totalPage);
		request.setAttribute("video", video);
		request.setAttribute("pageShow", soTrangShow);
		request.setAttribute("pageLast", totalPage);
		request.setAttribute("current", Integer.parseInt(page));
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/ChiTietTheLoai.jsp");
		rd.forward(request, response);
	}
	
	private int soLuongTrang(String limit,String idCate) {
		List<VideosModel> video = videoService.findByCategory(Long.parseLong(idCate));
		int sl = video.size() / Integer.parseInt(limit) ;
		return (video.size() % Integer.parseInt(limit) == 0) ? sl : sl+1;
	}
	
	private List<Integer> TrangShow(int page,int soTrang){
		List<Integer> soTrangShow = new ArrayList<Integer>();
		if(soTrang <= 3)
		{
			for(int i=1 ;i <= soTrang ;i++)
				soTrangShow.add(i);
		}else {
			if(soTrang - page >= 3) {
				for(int i=page ; i < page+3 ;i++) {
					soTrangShow.add(i);
				}
			}
			else {
				for(int i=soTrang-2 ; i <= soTrang ;i++) {
					soTrangShow.add(i);
				}
			}
		}
		return soTrangShow;
	}
}
