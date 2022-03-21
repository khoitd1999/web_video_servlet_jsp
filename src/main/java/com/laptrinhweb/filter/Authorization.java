package com.laptrinhweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.UsersModel;
import com.laptrinhweb.utils.SessionUtil;

public class Authorization implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) rq;
		HttpServletResponse response = (HttpServletResponse) rp;
		UsersModel user =(UsersModel) SessionUtil.getInstance().getValue(request, SystemConstant.MODEL);
		
		String url = request.getRequestURI();
		if(url.startsWith("/admin")) {
			if(user != null) {
				if(user.getIdR() == 1) {
					chain.doFilter(rq, rp);
				}else if(user.getIdR() == 2) {
					response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission"
							+ "&alert=danger");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission"
						+ "&alert=danger");
			}	
		}
		else {
			chain.doFilter(rq, rp);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
