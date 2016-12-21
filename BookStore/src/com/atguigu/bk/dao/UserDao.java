package com.atguigu.bk.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.atguigu.bk.dto.BuyRecord;
import com.atguigu.bk.dto.TurnPage;
import com.atguigu.bk.entity.TBuyDetail;
import com.atguigu.bk.entity.TUser;

public class UserDao extends BaseDao{
	
	public List<BuyRecord> getUserBuyRecord(String uname ,
                                       Date beginDate ,Date endDate,TurnPage tp) throws Exception{
		
		List<BuyRecord> records = null;
		
		String sql = "select d.bcount,bk.bname,bk.isbn,bk.press,bk.price,bk.pdate,br.allmoney,br.buytime,br.uname,br.buyid" +
				     " from tbuydetail d,tbuyrecord br,tbook bk " +
				     " where br.buyid = d.buyid and bk.isbn = d.isbn";
		if(uname != null && !uname.trim().equals("")){
			sql = sql + " and uname like '%" + uname + "%'";
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		if(beginDate != null){
			sql = sql + " and buytime>=" + "to_date('" + sd.format(beginDate) + "', 'yyyy-mm-dd')" ;
		}
		if(endDate != null){
			sql = sql + " and buytime<=" + "to_date('" + sd.format(endDate) + "', 'yyyy-mm-dd')" ;
		}		
		this.openConnection();	
		tp.allRows = this.getAllCount(sql);                          //记录总数
		tp.allPages = (tp.allRows-1)/tp.rowsOnePage + 1;
		int iStart,iEnd;               //记录数的起始值和结束值
		if(tp.currentPage > tp.allPages)
			tp.currentPage = tp.allPages;
		iStart = (tp.currentPage-1)*tp.rowsOnePage + 1;
		iEnd = iStart + tp.rowsOnePage;		
		String newSql = this.getTurnPageSql(sql, iStart, iEnd);			
		PreparedStatement ps = this.connection.prepareStatement(newSql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			records = new ArrayList<BuyRecord>(15);
			while(rs.next()){
				BuyRecord br = new BuyRecord();
				br.setAllmoney(rs.getDouble("allmoney"));
				br.setBcount(rs.getInt("bcount"));
				br.setBname(rs.getString("bname"));
				br.setBuyid(rs.getInt("buyid"));
				br.setBuytime(rs.getTimestamp("buytime"));
				br.setIsbn(rs.getString("isbn"));
				br.setPdate(rs.getDate("pdate"));
				br.setPress(rs.getString("press"));
				br.setPrice(rs.getDouble("price"));
				br.setUname(rs.getString("uname"));
				records.add(br);
			}
		}
		
		return records;
	}
	
	/**
	 * 对用户的账户，进行充值或扣款操作
	 * @param money为整数为充值操作，money为负数为扣款 
	 * @throws Exception
	 */
	public void updateUserAccount(String uname ,double money) throws Exception{
		String sql = "update tuser set account = account+? where uname=?";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, uname);
		ps.executeUpdate();		
	}
	
	public void addBuyRecord(String uname,double allMoney,Map<String,Integer> shopCar) throws Exception{
		String sql = "insert into tbuyrecord values ((select nvl(max(buyid),0)+1 from tbuyrecord),?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, uname);
		Date date = new Date();
		ps.setTimestamp(2, new Timestamp(date.getTime()));
		ps.setDouble(3, allMoney);
		ps.executeUpdate();
		Set<String> isbns = shopCar.keySet();
		for(String isbn : isbns){
			TBuyDetail detail = new TBuyDetail();
			detail.setIsbn(isbn);
			detail.setBuycount(shopCar.get(isbn));
			addBuyDetail(detail);			
		}

	}
	
	private void addBuyDetail(TBuyDetail detail) throws Exception{
		String sql = "insert into tbuydetail values( (select nvl(max(autoid),0)+1 from tbuydetail),?,(select nvl(max(buyid),0) from tbuyrecord),?)";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, detail.getIsbn());
		ps.setInt(2,detail.getBuycount());
		ps.executeUpdate();
		updateBookCount(detail.getIsbn(),-detail.getBuycount());
	}
	
	/**
	 * 增加库存或减少库存
	 * @param bookCount是正数为增加库存，bookCount是负数为减少库存
	 * @throws Exception
	 */
	public void updateBookCount(String isbn,int bookCount) throws Exception{
		String sql = "update tbook set bkcount=bkcount+? where isbn = ?";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setInt(1, bookCount);
		ps.setString(2, isbn);
		ps.executeUpdate();		
	} 
	
	/**
	 * 登录成功，返回TUser对象
	 * @param uname  
	 * @param pwd
	 * @return
	 */
	public TUser login(String uname,String pwd) throws Exception{
		TUser user = null;
		
		String sql = "select * from tuser where uname=? and pwd=?";		
		this.openConnection();      //打开数据库
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1,uname);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				user = new TUser();
				user.setUname(uname);
				user.setPwd(pwd);
				user.setAccount(rs.getDouble("account"));
				user.setRole(Integer.parseInt(rs.getString("role")));
				break;
			}			
		}
		//this.closeConnection();               不要在这个地方关闭数据库
		
		return user;
	}

}
