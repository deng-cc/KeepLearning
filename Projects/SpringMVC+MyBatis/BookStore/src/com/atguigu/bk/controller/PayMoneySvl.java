package com.atguigu.bk.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.UserBiz;
import com.atguigu.bk.entity.TUser;

public class PayMoneySvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PayMoneySvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}	

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getSession().getAttribute("user") != null){          
			String value = request.getParameter("allMoney");
			if(value != null){
				double allMoney = Double.parseDouble(value);
				UserBiz biz = new UserBiz();
				TUser user = (TUser)request.getSession().getAttribute("user");
				Map<String,Integer> car =  (Map<String,Integer>)request.getSession().getAttribute("ShopCar");
				try {
					biz.buyBooks(user.getUname(), allMoney,car);
					car.clear();				
					//request.getRequestDispatcher("/main/PaySuccess.jsp").forward(request, response);
					String path = request.getContextPath();
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					response.sendRedirect(basePath + "main/PaySuccess.jsp");
				} catch (Exception e) {
					request.setAttribute("msg", "网络异常，请和管理员联系");	
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}			
			}else{
				request.setAttribute("msg", "网络异常，请和管理员联系");	
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg","你访问了受限页面，请先登录");
			request.getRequestDispatcher("/main/login.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
