package com.estsoft.bookmall.app;
import java.util.List;

import com.estsoft.bookmall.dao.*;
import com.estsoft.bookmall.vo.*;

public class BookMall {

	public static void main(String[] args) {
		// 1. MemberDao의  회원 생성
		createMember();
		// 2. MemberDao의  회원 리스트
		List<MemberVo> listMember = new MemberDao().getList();
		for(MemberVo memberVo : listMember){
			System.out.println(memberVo);
		}

		// 3. CategoryDao의 카테고리 생성
		createCategory();
		// 4. CategoryDao의 카테고리 리스트
		List<CategoryVo> listCategory = new CategoryDao().getList();
		for( CategoryVo categoryVo : listCategory ) {
			System.out.println( categoryVo );
		}

		// 5. BookDao의 서적(상품) 생성
		createBook();
		// 6. BookDao의  서적(상품) 리스트
		List<BookVo> listBook = new BookDao().getList();
		for( BookVo bookVo : listBook ) {
			System.out.println( bookVo );
		}

		// 7. CartDao의 장바구니 정보 생성
		createCart();
		// 8. CartDao의  장바구니 내용 리스트
		List<CartVo> listCart = new CartDao().getList();
		for (CartVo cartVo : listCart) {
			System.out.println(cartVo);
		}

		// 9. OrderDao의 주문 생성
		createOrder();
		//10. OrderDao의  주문 리스트
		OrderDao orderDao = new OrderDao();
		List<OrderVo> listOrder = orderDao.getList();
		for (OrderVo orderVo : listOrder) {
			System.out.println(orderVo);
		}

		//이제 DB에 OrderedBooks 내용 입력에 필요한 내용들(JOIN에 쓰이는 테이블들의 내용)이 다 준비되어 있다.
		//*추가 - OrderedBooks의 내역 생성
		orderDao.insertOrderedBooks();
		//11. OrderDao의 주문 서적 리스트  
		List<OrderedBooksVo> listOrderedBooks = orderDao.getListOrderedBooks();
		for (OrderedBooksVo orderedBooksVo : listOrderedBooks) {
			System.out.println(orderedBooksVo);
		}
	}
	
	public static void createMember() {
		MemberVo memberVo = new MemberVo();
		MemberDao memberDao = new MemberDao();

		memberVo.setMemberId(1L);
		memberVo.setMemberName("Eclair Tartar");
		memberVo.setEmail("eclairsh@gmail.com");
		memberVo.setPassword("chocolatteCream");
		memberVo.setPhone("+82 10-9340-2345");
		memberDao.insert(memberVo);

		memberVo.setMemberId(1L);
		memberVo.setMemberName("Jellybean Soysauce");
		memberVo.setEmail("spinachBean@gmail.com");
		memberVo.setPassword("terrible");
		memberVo.setPhone("+82 10-3564-5648");
		memberDao.insert(memberVo);

		memberVo.setMemberId(1L);
		memberVo.setMemberName("TurkishDelight Garlic");
		memberVo.setEmail("TKDelight@gmail.com");
		memberVo.setPassword("EdwordNarnia");
		memberVo.setPhone("+82 10-7826-1589");
		memberDao.insert(memberVo);
	}
	
	public static void createCategory() {
		CategoryVo categoryVo = new CategoryVo();
		CategoryDao categoryDao = new CategoryDao();
		
		categoryVo.setCategoryId(1L);
		categoryVo.setCategoryName("Fiction");
		categoryDao.insert(categoryVo);
		
		categoryVo.setCategoryId(2L);
		categoryVo.setCategoryName("IT");
		categoryDao.insert(categoryVo);

		categoryVo.setCategoryId(3L);
		categoryVo.setCategoryName("Humanities");
		categoryDao.insert(categoryVo);

		categoryVo.setCategoryId(4L);
		categoryVo.setCategoryName("Art");
		categoryDao.insert(categoryVo);
	}

	public static void createBook() {
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
	
	public static void createCart() {
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
	
	public static void createOrder() {
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
}
