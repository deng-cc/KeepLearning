package com.atguigu.bk.controller.back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bk.biz.UserBiz;
import com.atguigu.bk.dto.BuyRecord;
import com.atguigu.bk.dto.TurnPage;
import com.atguigu.bk.util.Log;

public class BuyRecordSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BuyRecordSvl() {
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
		
		int pageNumber = 1;                                       //设置页号的默认值
		String pageNum = request.getParameter("page");
		String uname = request.getParameter("uname");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		Date bDate = null;
		Date eDate = null;
		UserBiz biz = new UserBiz();
		try {
			SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
			if(beginDate != null && !beginDate.trim().equals("")){
				try {
				    bDate = sd.parse(beginDate);	
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}				
			}
			if(endDate != null && !endDate.trim().equals("")){
				try {
				    eDate = sd.parse(endDate);	
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}				
			}	
			if(pageNum != null ){
			   try {
				   pageNumber = Integer.parseInt(pageNum);
			   } catch (Exception e) {
				   Log.logger.error(e.getMessage());
			   }	
			}
			TurnPage tp = new TurnPage();
			tp.rowsOnePage = 8;
			if(pageNumber<1)
				pageNumber = 1;			
			tp.currentPage = pageNumber;			
			List<BuyRecord> records = biz.getUserBuyRecord(uname,bDate,eDate,tp);
			request.setAttribute("records", records);
			request.setAttribute("uname",uname);
			request.setAttribute("beginDate",beginDate);
			request.setAttribute("endDate",endDate);
			request.setAttribute("CurrentPageNo",tp.currentPage);
			request.setAttribute("maxPageNo", tp.allPages);
			request.setAttribute("RecordAllCount", tp.allRows);
			request.getRequestDispatcher("/back/BuyRecord.jsp").forward(request, response);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
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
