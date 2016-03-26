package com.estsoft.bookmall.vo;

public class CartVo {
	private Long memberId;
	private Long bookId;
	private int quantity;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long customerId) {
		this.memberId = customerId;
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
		return "CartVo [customerId=" + memberId + ", bookId=" + bookId + ", quantity=" + quantity + "]";
	}
	
}
