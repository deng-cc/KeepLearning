package com.atguigu.bk.biz;

import java.util.List;
import java.util.Set;

import com.atguigu.bk.dao.BookDao;
import com.atguigu.bk.entity.TBook;
import com.atguigu.bk.util.Log;

public class BookBiz {
	
	/**
	 * 添加书籍
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
	 * 获取所有的书籍信息
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
	 * ���ָ����isbn����ȡ��Ӧ��ͼƬ
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
	 * ��������ȡ�����ϸ��Ϣ(����ͼƬ��Ϣ)
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
	 * ������������Ϣ����ȡ����ͼ����Ϣ
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
