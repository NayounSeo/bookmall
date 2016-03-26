package com.estsoft.bookmall.vo;

public class BookVo {
	private Long bookId;
	private Long categoryId;
	private String title;
	private int price;
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", categoryId=" + categoryId + ", title=" + title + ", price=" + price
				+ "]";
	}
}
