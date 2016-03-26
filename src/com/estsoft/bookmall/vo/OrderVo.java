package com.estsoft.bookmall.vo;

public class OrderVo {
	private Long orderId;
	private Long memberId;
	private Long bookId;
	private int price;
	private String address;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderVo [orderId=" + orderId + ", memberId=" + memberId + ", bookId=" + bookId + ", price=" + price
				+ ", address=" + address + "]";
	}
}
