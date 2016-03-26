package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.BookDao;
import com.estsoft.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		//insert test
		insertTest();
		//getList test
		getListTest();
	}

	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for( BookVo bookVo : list ) {
			System.out.println( bookVo );
		}
	}
	
	public static void insertTest() {
		BookVo bookVo = new BookVo();
		BookDao bookDao = new BookDao();
		
		bookVo.setBookId(1L);
		bookVo.setCategoryId(1L);
		bookVo.setTitle("Wizard of the EarthSea");
		bookVo.setPrice(11000);
		bookDao.insert(bookVo);
		
		bookVo.setBookId(2L);
		bookVo.setCategoryId(1L);
		bookVo.setTitle("Europa");
		bookVo.setPrice(4000);
		bookDao.insert(bookVo);

		bookVo.setBookId(3L);
		bookVo.setCategoryId(1L);
		bookVo.setTitle("Always Joyful Universe");
		bookVo.setPrice(9000);
		bookDao.insert(bookVo);

		bookVo.setBookId(4L);
		bookVo.setCategoryId(4L);
		bookVo.setTitle("Grand Budapest Hotel Art Book");
		bookVo.setPrice(18000);
		bookDao.insert(bookVo);

		bookVo.setBookId(5L);
		bookVo.setCategoryId(1L);
		bookVo.setTitle("What happened in the garden of Hotel");
		bookVo.setPrice(14000);
		bookDao.insert(bookVo);
		
		bookVo.setBookId(6L);
		bookVo.setCategoryId(1L);
		bookVo.setTitle("A Doll House");
		bookVo.setPrice(10000);
		bookDao.insert(bookVo);	
		
		bookVo.setBookId(7L);
		bookVo.setCategoryId(2L);
		bookVo.setTitle("This is JAVA");
		bookVo.setPrice(30000);
		bookDao.insert(bookVo);	
		
		bookVo.setBookId(8L);
		bookVo.setCategoryId(3L);
		bookVo.setTitle("Shallow and wide Knowledge for intellectual conversation");
		bookVo.setPrice(13000);
		bookDao.insert(bookVo);	
	}

}
