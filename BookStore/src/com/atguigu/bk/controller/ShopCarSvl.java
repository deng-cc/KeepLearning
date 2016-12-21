package com.atguigu.bk.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.entity.TBook;
import com.atguigu.bk.util.Log;

public class ShopCarSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShopCarSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	/**
	 * ���ﳵ�У�ֻ�洢isbn��������Ϣ�����ݿ���ȡ
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
         	
		if(request.getSession().getAttribute("user") != null){  
			Object object = request.getSession().getAttribute("ShopCar");
	         if(object != null){
	        	 Map<String,Integer> isbns =  (Map<String,Integer>)object; 
	        	 BookBiz biz = new BookBiz();
	            try {
	        		 List<TBook> books = biz.getBooks(isbns.keySet());
	        		 request.setAttribute("books",books);
	        		 request.getRequestDispatcher("/main/ShopCar.jsp").forward(request, response);
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
					request.setAttribute("msg", "�����쳣����͹���Ա��ϵ");	
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}        	 
	        	 
	         }else{
	        	 request.getRequestDispatcher("/main/ShopCar.jsp").forward(request, response);
	         }
		}else{
			request.setAttribute("msg","�����������ҳ�棬���ȵ�¼");
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
