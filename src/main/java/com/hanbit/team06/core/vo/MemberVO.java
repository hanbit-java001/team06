package com.hanbit.team06.core.vo;

public class MemberVO {

	private int memberId;
	private String memberName;
	private String memberEmail;
	private String memberPw;
	private String memberApi;

	private String currentPassword;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getMemberApi() {
		return memberApi;
	}

	public void setMemberApi(String memberApi) {
		this.memberApi = memberApi;
	}

}
