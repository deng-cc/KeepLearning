package com.atguigu.bk.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.atguigu.bk.entity.TBook;

public class BookDao extends BaseDao{
	
	/**
	 * 
	 * @param book
	 * @throws Exception
	 */
	public void addBook(TBook book) throws Exception{
		String sql = "insert into  tbook(isbn,bname,press,price,pdate,pic,bkcount)  values(?,?,?,?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getBname());
		ps.setString(3, book.getPress());
		ps.setDouble(4, book.getPrice());
		ps.setDate(5, new java.sql.Date(book.getPdate().getTime()));
		ps.setBytes(6, book.getPic());
		ps.setInt(7, 1000);
		ps.executeUpdate();		
	}
	
	/**
	 * ��ҳ��ʾ������ͼ����Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getAllBooks() throws Exception{
		List<TBook> books = null;
		
		String sql = "select isbn,bname,press,price,pdate from tbook order by isbn" ;
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			books = new ArrayList<TBook>();
			while(rs.next()){
				TBook bk = new TBook();
				bk.setBname(rs.getString("bname"));
				bk.setIsbn(rs.getString("isbn"));
				bk.setPdate(rs.getDate("pdate"));
				bk.setPress(rs.getString("press"));
				bk.setPrice(rs.getDouble("price"));
				books.add(bk);
			}
			
		}
		
		return books;
	}
	
	/**
	 * ���ָ����isbn����ȡ��Ӧ��ͼƬ
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public byte[] getBookPic(String isbn) throws Exception{
		byte[] pic = null;
				
		String sql = "select pic from tbook where isbn = ?";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();

        //todo rs=true,执行完if的条件判断后变为了false，未解之谜
        if(rs != null){
			while(rs.next()){
				pic = rs.getBytes("pic");
				break;
			}
		}

		return pic;
	}
	
	/**
	 * ��������ȡ�����ϸ��Ϣ������ͼƬ��Ϣ��
	 * @return
	 * @throws Exception
	 */
	public TBook getBookDetail(String isbn) throws Exception{
		TBook book = null;
		
		String sql = "select isbn,bname,press,price,pdate from tbook where isbn=?";		
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
		      book = new TBook();
		      book.setBname(rs.getString("bname"));
		      book.setIsbn(rs.getString("isbn"));
		      book.setPdate(rs.getDate("pdate"));
		      book.setPress(rs.getString("press"));
		      book.setPrice(rs.getDouble("price"));
			  break;
			}
		}	
		
		return book;
	}
	

	/**
	 * ������������Ϣ����ȡ����ͼ����Ϣ
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getBooks(Set<String> isbns) throws Exception{
		List<TBook> books = null;
		
		String strIsbns = "";
		int ii = 0;
		for(String isbn : isbns){			
			if(ii==0){
				strIsbns =  "'" + isbn + "'";	
			}else{
				strIsbns = strIsbns + "," + "'" + isbn + "'";				
			}			
			ii++;
		}		
		String sql = "select isbn,bname,press,price,pdate from tbook where isbn in ( " + strIsbns + ")";
		this.openConnection();
		Statement st = this.connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs != null){
			books = new ArrayList<TBook>();
			while(rs.next()){
		      TBook book = new TBook();
		      book.setBname(rs.getString("bname"));
		      book.setIsbn(rs.getString("isbn"));
		      book.setPdate(rs.getDate("pdate"));
		      book.setPress(rs.getString("press"));
		      book.setPrice(rs.getDouble("price"));
			  books.add(book);
			}
		}			
		
		return books;
	}



}
