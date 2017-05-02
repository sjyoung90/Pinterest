package com.zzim.dto;

public class Comment {
	private int commentNum;
	private String userID;
	private int photoNum;
	private String content;
	private String createDate;
	
	public Comment(int commentNum, String userID, int photoNum, String content,
			String createDate) {
		super();
		this.commentNum = commentNum;
		this.userID = userID;
		this.photoNum = photoNum;
		this.content = content;
		this.createDate = createDate;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Comment [commentNum=" + commentNum + ", userID=" + userID
				+ ", photoNum=" + photoNum + ", content=" + content
				+ ", createDate=" + createDate + "]";
	}
	
	
}
