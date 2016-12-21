package com.atguigu.bk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class DbInfo {
	private static DbInfo dbInfo;              //单例
	private ConfigInfo configInfo;
	
	private DbInfo() {
		configInfo = new ConfigInfo();
		getProperties();
	}
	
	public static DbInfo newInstance(){
		if (dbInfo == null)
			dbInfo = new DbInfo();
		
		return dbInfo;
	}
	
   public String getDbdriver(){
		
		String dbDriver = null;
		
		if(configInfo != null){
			dbDriver = this.configInfo.getDbdriver();
		}
		
		return dbDriver;
		
	}
	
	public String getdbURL(){
		String dbURL = null;
		if(configInfo != null){
			dbURL = this.configInfo.getUri();
		}
		
		return dbURL;
	}
	
	
	public String getUname(){
		String uname = null;
		if(this.configInfo != null){
			uname = this.configInfo.getUname();
		}
		
		return uname;		
	}
	
	public String getPwd(){
		
		String pwd = null;
		if(this.configInfo != null){
			pwd = this.configInfo.getPwd();
		}
		
		return pwd;
	}
	
	
	/**
	 * 读取配置文件
	 */
	private void getProperties() {
		FileInputStream fis = null;
		
		try {
			String uString = DbInfo.class.getResource("/").toURI().getPath() + "db.properties";
			File file = new File(uString);
			Properties properties = new Properties();
			
			fis = new FileInputStream(file);;
			properties.load(fis);
			configInfo.setDbdriver(properties.getProperty("dbdriver"));
			configInfo.setUri(properties.getProperty("dbURL"));
			configInfo.setUname(properties.getProperty("uname"));
			configInfo.setPwd(properties.getProperty("pwd"));			
		} catch (FileNotFoundException e) {
			Log.logger.error(e.getMessage());
		} catch (IOException e) {
			Log.logger.error(e.getMessage());
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}finally{
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					Log.logger.error(e.getMessage());
				}
			}			
		}
	}	
}

class ConfigInfo {
	private String uri;
	private String uname;
	private String pwd;
	private String dbdriver;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDbdriver() {
		return dbdriver;
	}

	public void setDbdriver(String dbdriver) {
		this.dbdriver = dbdriver;
	}
}
