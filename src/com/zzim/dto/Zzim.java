package com.zzim.dto;

public class Zzim {
	private String userID;
	private int photoNum;
	
	public Zzim(String userID, int photoNum) {
		super();
		this.userID = userID;
		this.photoNum = photoNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}

	@Override
	public String toString() {
		return "Zzim [userID=" + userID + ", photoNum=" + photoNum + "]";
	}

}
