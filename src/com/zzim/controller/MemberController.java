package com.zzim.controller;

import java.sql.SQLException;

import com.zzim.dao.MemberDAO;
import com.zzim.dto.Member;

public class MemberController {
	
	/*
	 * 로그인 시, 아이디&비밀번호 체크
	 */
	public String checkMember(String memberID, String memberPW) throws SQLException{
		String loginState = "loginFail";
		
		MemberDAO md = new MemberDAO();
		Member member = md.getMember(memberID);
		
		if(member.getId() == null) {
			//아이디 존재하지 않음
			loginState = "idFail";
		}
		else {			
			if(memberPW.equals(member.getPw())){				
				System.out.println("로그인 성공");
				loginState = "loginSuccess";				
			}
			else{
				System.out.println("비밀번호가 일치하지 않습니다.");
				loginState = "pwFail";				
			}
		}
		return loginState;
	}
	
	/*
	 * 회원가입 시, 아이디 중복확인
	 */
	public boolean dupliCheck(String id) throws SQLException {
		MemberDAO md = new MemberDAO();
		Member member = md.getMember(id);
		
		if(member != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * 회원가입 성공여부
	 */
	public boolean joinMember(Member member) throws SQLException{
		MemberDAO md = new MemberDAO();
		
		if(md.setMember(member)) {
			return true;
		}
		else {		
			return false;
		}		
	}
	
	/*
	 * 회원정보 수정 성공여부
	 */
	public boolean updateMember(Member member) throws SQLException{
		MemberDAO md = new MemberDAO();
		
		if(md.updateMember(member)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*
	 * 탈퇴 전 비밀번호 확인
	 */
	public boolean checkPW(String id, String pw) throws SQLException{
		MemberDAO md = new MemberDAO();
		Member member = md.getMember(id);
		
		if(pw.equals(member.getPw())){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * 회원탈퇴 성공여부
	 */
	public boolean deleteMember(String id) throws SQLException{
		MemberDAO md = new MemberDAO();
		
		if(md.delMember(id)) {
			return true;
		}
		else {
			return false;
		}
	}
}
