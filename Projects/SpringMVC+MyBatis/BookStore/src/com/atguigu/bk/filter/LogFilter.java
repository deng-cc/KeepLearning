package com.atguigu.bk.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.atguigu.bk.util.Log;

public class LogFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)request;
		ServletContext application = req.getSession().getServletContext();
		Object object = application.getAttribute("PageView");
		if(object != null){
			Integer pageview = (Integer)object;			
			application.setAttribute("PageView", pageview+1);
		}else{			
			application.setAttribute("PageView",1);
		}
		Log.logger.info(req.getRequestURL());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Log.logger.info("访问开始时间" + sd.format(new Date()));
		
		chain.doFilter(request, response);
		
		Log.logger.info("访问结束时间" + sd.format(new Date()));
		
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
