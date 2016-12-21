package com.atguigu.bk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.UserBiz;
import com.atguigu.bk.entity.TUser;
import com.atguigu.bk.exception.InputNullExcepiton;

public class LoginSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/main/login.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		if(uname != null && pwd != null && !uname.equals("") && !pwd.equals("") ){
			UserBiz biz = new UserBiz();
			try {
				TUser user = biz.login(uname, pwd);	
				if(user != null){
					//用户登录成功了
					request.getSession().setAttribute("user",user);
					request.getRequestDispatcher("/MainSvl").forward(request, response);
				}else{
					request.setAttribute("msg", "用户名、或密码错误，请检查");
					request.getRequestDispatcher("/main/login.jsp").forward(request, response);
				}
			} catch (InputNullExcepiton e) {
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("/main/login.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			   request.setAttribute("msg", "网络异常，请和管理员联系");	
			   request.getRequestDispatcher("/error.jsp").forward(request, response);
			}			
		}else{
			request.setAttribute("msg","用户名或密码，不能为空");
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
