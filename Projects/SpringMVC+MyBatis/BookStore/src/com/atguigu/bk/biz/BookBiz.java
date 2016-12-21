package com.atguigu.bk.biz;

import java.util.List;
import java.util.Set;

import com.atguigu.bk.dao.BookDao;
import com.atguigu.bk.entity.TBook;
import com.atguigu.bk.util.Log;

public class BookBiz {
	
	/**
	 * 
	 * @param book
	 * @throws Exception
	 */
	public void addBook(TBook book) throws Exception{
		BookDao dao = new BookDao();
		try {
			dao.addBook(book);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}		
	}
	
	
	/**
	 * 主页显示，所有图书信息
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getAllBooks() throws Exception{
		List<TBook> books = null;
		
		BookDao dao = new BookDao();
		try {
			books = dao.getAllBooks();	
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}finally{
			dao.closeConnection();
		}
		
		return books;		
	}
	
	/**
	 * 根据指定的isbn，提取对应的图片
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public byte[] getBookPic(String isbn) throws Exception{
		byte[] pic = null;
		
		BookDao dao = new BookDao();
		try {
			pic = dao.getBookPic(isbn);			
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		
		return pic;
	}
	
	/**
	 * 根据书号提取书的详细信息(不含图片信息)
	 * @return
	 * @throws Exception
	 */
	public TBook getBookDetail(String isbn) throws Exception{
		TBook book = null;
		
		BookDao dao = new BookDao();
		try {
			book = dao.getBookDetail(isbn);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		
		return book;
	}
	
	/**
	 * 根据书的主键信息，提取所有图书信息
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<TBook> getBooks(Set<String> isbns) throws Exception{
		List<TBook> books = null;
		
		BookDao dao = new BookDao();
		try {
			if(isbns.size() > 0)
				books = dao.getBooks(isbns);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}		
		
		return books;
	}

}
