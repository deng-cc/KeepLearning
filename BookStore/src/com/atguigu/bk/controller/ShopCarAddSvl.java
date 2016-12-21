package com.atguigu.bk.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopCarAddSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShopCarAddSvl() {
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
		
		String isbn = request.getParameter("isbn");
		if(isbn != null){
			//先判断当前用户是否已经登录
			if(request.getSession().getAttribute("user") != null){
				Object object = request.getSession().getAttribute("ShopCar");
				if(object == null){
					Map<String,Integer> shopCar = new HashMap<String,Integer>();
					shopCar.put(isbn,1);
					request.getSession().setAttribute("ShopCar",shopCar);					
				}else{
					Map<String,Integer> shopCar = (Map<String,Integer>)object;
					shopCar.put(isbn,1);
				}				
				request.getRequestDispatcher("/ShopCarSvl").forward(request, response);
			}else{
				//没有登录
				request.getRequestDispatcher("/main/login.jsp").forward(request, response);
			}
			
		}else{
			request.setAttribute("msg", "网络异常，请和管理员联系");	
			request.getRequestDispatcher("/error.jsp").forward(request, response);
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
