package com.atguigu.bk.controller.back;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.entity.TBook;
import com.atguigu.bk.entity.TUser;
import com.atguigu.bk.enums.RoleEnum;
import com.atguigu.bk.util.Log;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

public class BookAddSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookAddSvl() {
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
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {				
		request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);			
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
	public void doPost(HttpServletRequest request2, HttpServletResponse response2)
			throws ServletException, IOException {
		
		SmartUpload  smu = new SmartUpload();		
		smu.initialize(this.getServletConfig(),request2,response2);
		smu.setCharset("gbk");
		smu.setAllowedFilesList("gif,jpg,png,bmp");
		smu.setMaxFileSize(100*1024);		                 //最大允许100K     
		
		try {
			smu.upload();
			com.jspsmart.upload.Request  request =  smu.getRequest();
			String isbn =  request.getParameter("isbn");
			if(isbn != null  && !isbn.trim().equals("")){
				String bname = request.getParameter("bname");
				String press = request.getParameter("press");
				String pdate = request.getParameter("pdate");
				String price = request.getParameter("price");	
				TBook book = new TBook();
			    book.setIsbn(isbn);
			    book.setBname(bname);	
			    book.setPress(press);
			    if(pdate != null && !pdate.equals("")){
			    	SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
			    	try {
			    		book.setPdate(sd.parse(pdate));	
					} catch (Exception e) {
						Log.logger.error(e.getMessage());
					}			    	
			    }
			    if(price != null  && !price.equals("")){		
			    	try {
			    		book.setPrice(Double.parseDouble(price));
					} catch (Exception e) {
						Log.logger.error(e.getMessage());
					}
			    	
			    }
			    File file = smu.getFiles().getFile(0);     //支持多个文件同时上传
			    if( file != null ){
			    	int size = file.getSize();
					byte[] bytesPic = new byte[size];
					for(int i=0;i<size;i++){
						bytesPic[i] = file.getBinaryData(i);					
					}
					book.setPic(bytesPic);
			    }			    
			    BookBiz biz = new BookBiz();
			    biz.addBook(book);
			    request2.setAttribute("msg",bname + "--录入成功");
			    request2.getRequestDispatcher("/back/BookAdd.jsp").forward(request2, response2);
			}else{
				request2.setAttribute("msg","isbn不能为空");
				request2.getRequestDispatcher("/back/BookAdd.jsp").forward(request2, response2);
			}
		}catch(SecurityException e){			
			request2.setAttribute("msg",e.getMessage());
			request2.getRequestDispatcher("/back/BookAdd.jsp").forward(request2, response2);
		}catch (Exception e) {
			e.printStackTrace();
			request2.setAttribute("msg", e.getMessage());	
			request2.getRequestDispatcher("/error.jsp").forward(request2, response2);
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
