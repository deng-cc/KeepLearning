package com.atguigu.bk.entity;

import java.util.Date;

public class TBook {
	private String isbn;
	private String bname;
	private String press;
	private double price;
	private Date pdate;
	private byte[] pic;
	private int buyCount;               //购物车中提交的，图书购买数量
	private int bkCount;                //图书的库存数量
	
	
	public int getBkCount() {
		return bkCount;
	}
	public void setBkCount(int bkCount) {
		this.bkCount = bkCount;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}

}
