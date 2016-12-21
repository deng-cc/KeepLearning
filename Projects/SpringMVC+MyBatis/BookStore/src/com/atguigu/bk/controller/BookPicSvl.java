package com.atguigu.bk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.util.Log;

public class BookPicSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookPicSvl() {
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
			BookBiz biz = new BookBiz();
			try {
				byte[] pic = biz.getBookPic(isbn);
				if(pic != null ){
					ServletOutputStream out = response.getOutputStream();
					out.write(pic);
					out.flush();
					out.close();	
				}								
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
				request.setAttribute("msg", "网络异常，请和管理员联系");	
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}			
		}else{
			request.setAttribute("msg", "isbn不能为null");	
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
