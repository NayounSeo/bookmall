package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.CartDao;
import com.estsoft.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//insert Test
		insertTest();
		//getListTest
		getListTest();		
	}
	
	public static void getListTest( ) {
		List<CartVo> list = new CartDao().getList();
		for (CartVo cartVo : list) {
			System.out.println(cartVo);
		}
	}
	
	public static void insertTest() {
		CartVo cartVo = new CartVo( );
		CartDao cartDao = new CartDao( );
		
		cartVo.setMemberId(1L);
		cartVo.setBookId(1L);
		cartVo.setQuantity(1);
		cartDao.insert(cartVo);
		
		cartVo.setMemberId(3L);
		cartVo.setBookId(4L);
		cartVo.setQuantity(2);
		cartDao.insert(cartVo);
		
		cartVo.setMemberId(2L);
		cartVo.setBookId(8L);
		cartVo.setQuantity(1);
		cartDao.insert(cartVo);
		
		cartVo.setMemberId(1L);
		cartVo.setBookId(7L);
		cartVo.setQuantity(10);
		cartDao.insert(cartVo);
		
	}
}
