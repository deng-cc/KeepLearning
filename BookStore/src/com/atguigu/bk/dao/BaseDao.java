package com.atguigu.bk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atguigu.bk.util.DbInfo;
import com.atguigu.bk.util.Log;

public class BaseDao {
	
	protected Connection connection;	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void openConnection() throws Exception{
		
		try {
			if(connection == null || connection.isClosed()){				
				DbInfo dbInfo = DbInfo.newInstance();				
				Class.forName(dbInfo.getDbdriver());	    //�������������Ƿ����
				connection = DriverManager.getConnection(dbInfo.getdbURL(),dbInfo.getUname(),dbInfo.getPwd());	
			}			
		} catch (ClassNotFoundException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}catch (SQLException e){
			Log.logger.error(e.getMessage());
			throw e;
		}				
	}
	
	public void closeConnection(){
		
		if(this.connection != null){
			try {
				this.connection.close();	
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
			}			
		}
		
	}
	
	public void beginTransaction() throws Exception{
		this.openConnection();
		this.connection.setAutoCommit(false);           //�����ݿ���ύģʽ��Ϊ�ֶ��ύ
	}
	
	public void commit() throws Exception{
	   if(this.connection != null)
		   this.connection.commit();
	}
	
	public void rollback()throws Exception{
		if(this.connection != null)
			this.connection.rollback();
	}
	
	/**
	 * ����ORACLE�ķ�ҳд�����Դ����sql��װ�ɷ�ҳ�㷨��sql
	 * @param sql
	 * @param iStart
	 * @param iEnd
	 * @return
	 */
	protected String getTurnPageSql(String sql,int iStart,int iEnd){
		
		String newSql = "";
		newSql = "select * from (select rownum rnum ,tb.* from (" + sql + ") tb ) where rnum>=" + iStart + " and rnum<" + iEnd;
		
		return newSql;
	}
	
	/**
	 * ���ݴ����sql������Ҫ��ѯ�ļ�¼����
	 * @param sql
	 * @return
	 */
	protected int getAllCount(String sql) throws Exception{
		int allCount = 0;
		
		String newSql = "select count(*)  from (" + sql +")tb";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(newSql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
		      allCount = rs.getInt(1);	
		      break;
			}
		}
		
		return allCount;
	}

}
