package com.zzim.dto;

public class Photo {
	private int photoNum;
	private String fileName;
	private String explain;
	private int boardNum;
	private String uploadDate;
	
	public Photo() {
		
	}
	
	public Photo(int photoNum, String fileName, String explain,
			int boardNum, String uploadDate) {
		super();
		this.photoNum = photoNum;
		this.fileName = fileName;
		this.explain = explain;
		this.boardNum = boardNum;
		this.uploadDate = uploadDate;
	}

	public int getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "Photo [photoNum=" + photoNum + ", fileName=" + fileName
				+ ", explain=" + explain + ", boardNum=" + boardNum
				+ ", uploadDate=" + uploadDate + "]";
	}
	
	
	
	
}
