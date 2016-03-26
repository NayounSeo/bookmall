package com.estsoft.bookmall.vo;
//Table orderedBooks의 Vo 입니다.
//OrderedBooksDao는 따로 구현하지 않고 OrderDao에서 필요한 내용을 구현해 두었습니다.
/*OrderDao에서 getList 구현 중 테이블의 attribute들을 모두 다루기에는
	객체로 다루는 편이 나을 것이라고 생각해 만들었습니다.*/
public class OrderedBooksVo {
	private Long orderId;
	private Long bookId;
	private int quantity;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderedBooksVo [orderId=" + orderId + ", bookId=" + bookId + ", quantity=" + quantity + "]";
	}
}
