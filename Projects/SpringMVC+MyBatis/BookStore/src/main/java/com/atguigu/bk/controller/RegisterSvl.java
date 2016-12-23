package com.atguigu.bk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterSvl() {
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
		
		String reponsetext;
		try {
			Thread.sleep(4000);	
		} catch (Exception e) {

		}
		

		String uname = request.getParameter("uname");
		if(uname != null && !uname.trim().equals("")){
			if(uname.equals("admin") || uname.equals("tom")){
				reponsetext = "���û����Ѿ����ڣ�����������";
			}else{
				reponsetext = "��������û������ʹ��";
			}
		}else{
			reponsetext = "";
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		out.println(reponsetext);
		out.flush();
		out.close();		
		//����ʹ�� request.getRequestDispatcher(arg0)
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
