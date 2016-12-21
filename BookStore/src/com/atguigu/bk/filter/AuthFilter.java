package com.atguigu.bk.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.atguigu.bk.entity.TUser;
import com.atguigu.bk.enums.RoleEnum;

public class AuthFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(request instanceof HttpServletRequest){
			HttpServletRequest req = (HttpServletRequest)request;			
			Object object = req.getSession().getAttribute("user");
			if(object != null){
				TUser user = (TUser)object;
				if(user.getRole() == RoleEnum.ADMIN){
					chain.doFilter(request, response);					
				}else{
					request.setAttribute("msg","访问页面的权限受限，请先登录");
					req.getRequestDispatcher("/main/login.jsp").forward(request, response);
				}				
			}else{
				request.setAttribute("msg","访问页面的权限受限，请先登录");
				req.getRequestDispatcher("/main/login.jsp").forward(request, response);
			}
		}	
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
