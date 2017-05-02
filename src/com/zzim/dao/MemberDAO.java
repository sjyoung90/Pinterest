package com.zzim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzim.db.DBConnection;
import com.zzim.dto.Member;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	/*
	 * Create. DB에 저장
	 */
	public boolean setMember(Member member){
		boolean setSuccess = false;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("insert into member values (?, ?, ?, ?, ?)");

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getB_date());
			
			setSuccess = psmt.execute();
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			if(psmt != null){
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return setSuccess;
	}
	
	/*
	 * Read. DB에서 불러옴
	 */
	public Member getMember(String id){
		Member member = null;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("select * from member where id = '" + id + "'");
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				member = new Member();
				
				member.setId(rs.getString("ID"));
				member.setPw(rs.getString("PW"));
				member.setName(rs.getString("NAME"));
				member.setGender(rs.getString("Gender"));
				member.setB_date(rs.getString("B_DATE"));
				
			}			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(psmt != null){
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return member; //null인지 아닌지 체크하기
	}
	
	/*
	 * Update. 회원정보 업데이트
	 */
	public boolean updateMember(Member member){
		boolean updateSuccess = false;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("update member set PW=?, NAME=?, GENDER=?, B_DATE=? where id='" + member.getId() +"'");
			
			psmt.setString(1, member.getPw());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getGender());
			psmt.setString(4, member.getB_date());
			
			updateSuccess = psmt.execute();
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			if(psmt != null){
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return updateSuccess;
	}
	
	/*
	 * Delete. DB에서 삭제
	 */
	public boolean delMember(String id) throws SQLException {
		boolean deleteSuccess = false;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("delete from member where id = '" + id + "'");
			
			psmt.executeUpdate();
			
			deleteSuccess = true;
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			if(psmt != null){
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deleteSuccess;
	}
}
