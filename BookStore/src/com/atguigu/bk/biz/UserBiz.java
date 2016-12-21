package com.atguigu.bk.biz;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.atguigu.bk.dao.UserDao;
import com.atguigu.bk.dto.BuyRecord;
import com.atguigu.bk.dto.TurnPage;
import com.atguigu.bk.entity.TUser;
import com.atguigu.bk.exception.InputNullExcepiton;
import com.atguigu.bk.util.Log;

public class UserBiz {
	
	/**
	 * 查询用户的购买记录
	 * @return
	 * @throws Exception
	 */
	public List<BuyRecord> getUserBuyRecord(String uname ,
			                          Date beginDate ,Date endDate,TurnPage tp) throws Exception{
		List<BuyRecord> records = null;
		UserDao dao = new UserDao();
		try {
			records = dao.getUserBuyRecord(uname,beginDate,endDate,tp);	
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	
		return records;
	}
	
	/**
	 * 使用事务控制，进行图书付款
	 * @param uname
	 * @param allMoney
	 * @param books
	 * @throws Exception
	 */
	public void buyBooks(String uname,double allMoney,Map<String,Integer> shopCar) throws Exception{
		
		UserDao dao = new UserDao();	
		try {			
			dao.beginTransaction();                         //开始事务			
			dao.updateUserAccount(uname, -allMoney);		
			dao.addBuyRecord(uname, allMoney, shopCar);
			dao.commit();                                   //无异常，就提交事务
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollback();                                 //有异常，回滚
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	}
	
	
	
	/**
	 * 登录成功，返回TUser对象
	 * @param uname  
	 * @param pwd
	 * @return
	 */
	public TUser login(String uname,String pwd) throws Exception{
		TUser user = null;
		
		if(uname != null && pwd != null && !uname.equals("") && !pwd.equals("") ){
		    UserDao dao = new UserDao();
		    try {
		    	user = dao.login(uname, pwd);	
			} catch (Exception e) {				
				Log.logger.error(e.getMessage());
				throw e;
			}finally{
				dao.closeConnection();                  //数据库必须在此处关闭
			}
		    	
		    
		}else{
			throw new InputNullExcepiton("用户名或密码不能为空");			
		}
		return user;
	}

	
}
