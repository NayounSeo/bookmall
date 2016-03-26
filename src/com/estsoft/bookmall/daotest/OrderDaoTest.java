package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.OrderDao;
import com.estsoft.bookmall.vo.OrderVo;
import com.estsoft.bookmall.vo.OrderedBooksVo;

//주문 서적 내용까지 한번에 처리하라고 한 건 어떻게 하라는 거지..?
public class OrderDaoTest {
	public static void main(String[] args) {
		//insert Test - Orders
		insertTest();
		//getListTest - Orders
		getListTest();
		
		//insert Test - OrderedBooks
		insertTestOrderedBooks();
		//getListTest - OrderedBooks
		getListTestOrderedBooks();
	}
	
	public static void getListTest() {
		List<OrderVo> list = new OrderDao().getList();
		for (OrderVo orderVo : list) {
			System.out.println(orderVo);
		}
	}

	//주문 서적을 OrderDaoTest에서 구현한다는 건 서적과 주문의 JOIN으로 구현하라는 건가..?
	public static void insertTest() {
		OrderVo orderVo = new OrderVo();
		OrderDao orderDao = new OrderDao();
		
		orderVo.setOrderId(1L);
		orderVo.setMemberId(1L);
		orderVo.setBookId(7L);
		orderVo.setPrice(300000);
		orderVo.setAddress("Banpodaero 3 EstSoft, Seochogu, Seoul");
		orderDao.insert(orderVo);
		
		orderVo.setOrderId(2L);
		orderVo.setMemberId(3L);
		orderVo.setBookId(4L);
		orderVo.setPrice(36000);
		orderVo.setAddress("Jamsildaero 60-3, Songpagu, Seoul");
		orderDao.insert(orderVo);
		
		orderVo.setOrderId(3L);
		orderVo.setMemberId(1L);
		orderVo.setBookId(1L);
		orderVo.setPrice(11000);
		orderVo.setAddress("Cheonhodaero 30-3, Gangdonggu, Seoul");
		orderDao.insert(orderVo);
		
		orderVo.setOrderId(4L);
		orderVo.setMemberId(2L);
		orderVo.setBookId(8L);
		orderVo.setPrice(13000);
		orderVo.setAddress("Gildong 94-2, Gangdonggu, Seoul");
		orderDao.insert(orderVo);	
	}
	
	public static void insertTestOrderedBooks() {
		OrderDao orderDao = new OrderDao();
		orderDao.insertOrderedBooks();
	}
	
	public static void getListTestOrderedBooks() {
		List<OrderedBooksVo> list = new OrderDao().getListOrderedBooks();
		for (OrderedBooksVo orderedBooksVo : list) {
			System.out.println(orderedBooksVo);
		}
	}
}
