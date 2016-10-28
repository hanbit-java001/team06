package com.hanbit.team06.core.vo;

public class GalleryVO {
	private int photoId;
	private String photoName;
	private String photoDate;
	private String photoRes1;
	private String photoRes2;
	private String photoPath;
	private int memberId;
	private int hachTagId1;
	private int hachTagId2;
	private int hachTagId3;
	private byte[] fileData;
	private String contentType;
	private long fileSize;
	private String thumbnail;

	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(String photoDate) {
		this.photoDate = photoDate;
	}
	public String getPhotoRes1() {
		return photoRes1;
	}
	public void setPhotoRes1(String photoRes1) {
		this.photoRes1 = photoRes1;
	}
	public String getPhotoRes2() {
		return photoRes2;
	}
	public void setPhotoRes2(String photoRes2) {
		this.photoRes2 = photoRes2;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getHachTagId1() {
		return hachTagId1;
	}
	public void setHachTagId1(int hachTagId1) {
		this.hachTagId1 = hachTagId1;
	}
	public int getHachTagId2() {
		return hachTagId2;
	}
	public void setHachTagId2(int hachTagId2) {
		this.hachTagId2 = hachTagId2;
	}
	public int getHachTagId3() {
		return hachTagId3;
	}
	public void setHachTagId3(int hachTagId3) {
		this.hachTagId3 = hachTagId3;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


}
