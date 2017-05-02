package com.zzim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzim.db.DBConnection;
import com.zzim.dto.Photo;

public class PhotoDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	/*
	 * Create or Update. DB에 저장
	 */
	public boolean setPhoto(Photo photo) {
		boolean setSuccess = false;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("insert into photo values (?, ?, ?, ?, ?)");

			psmt.setInt(1, photo.getPhotoNum());
			psmt.setString(2, photo.getFileName());
			psmt.setString(3, photo.getExplain());
			psmt.setInt(4, photo.getBoardNum());
			psmt.setString(5, photo.getUploadDate());
			
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
	public Photo getPhoto(int photoNum) {
		Photo photo = null;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("select * from photo where PHOTO_NUM = '" + photoNum + "'");
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				photo = new Photo();
				
				photo.setPhotoNum(rs.getInt("PHOTO_NUM"));
				photo.setFileName(rs.getString("FILE_NAME"));
				photo.setExplain(rs.getString("EXPLAIN"));
				photo.setBoardNum(rs.getInt("BOARD_NUM"));
				photo.setUploadDate(rs.getString("UPDATE_DATE"));
				
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
		return photo; //null인지 아닌지 서버에서 체크
	}
	
	/*
	 * Delete. DB에서 삭제
	 */
	public boolean delPhoto(int photoNum) {
		boolean deleteSuccess = false;
		try{
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement("delete from photo where PHOTO_NUM = '" + photoNum + "'");
			
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
