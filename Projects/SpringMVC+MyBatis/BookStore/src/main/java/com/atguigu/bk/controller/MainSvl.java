package com.atguigu.bk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.entity.TBook;

public class MainSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MainSvl() {
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

		BookBiz biz = new BookBiz();
		try {
			List<TBook> books = biz.getAllBooks();
			request.setAttribute("books",books);
			request.getRequestDispatcher("/main/main.jsp").forward(request, response);			
		} catch (Exception e) {
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
