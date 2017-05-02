package com.zzim.dto;

public class Board {
	private int boardNum;
	private String userID;
	private String boardName;
	private String explain;
	private String createDate;
	private Photo photo; //Photo 객체
	
	public Board(int boardNum, String userID, String boardName,
			String explain, String createDate, Photo photo) {
		super();
		this.boardNum = boardNum;
		this.userID = userID;
		this.boardName = boardName;
		this.explain = explain;
		this.createDate = createDate;
		this.photo = photo;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", userID=" + userID
				+ ", boardName=" + boardName + ", explain=" + explain
				+ ", createDate=" + createDate
				+ ", photo=" + photo + "]";
	}
}
