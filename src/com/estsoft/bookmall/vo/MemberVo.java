package com.estsoft.bookmall.vo;

public class MemberVo {
	private Long memberId;
	private String memberName;
	private String email;
	private String password;
	private String phone;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberName=" + memberName + ", email=" + email + ", password="
				+ password + ", phone=" + phone + "]";
	}
}
