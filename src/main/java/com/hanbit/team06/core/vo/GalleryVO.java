package com.hanbit.team06.core.vo;

public class GalleryVO {
	private int photoId;
	private String photoName;
	private String photoDate;
	private String photoRes1;
	private String photoRes2;
	private String photoPath;
	private int memberId;
	private int hashTagId1;
	private int hashTagId2;
	private int hashTagId3;
	private byte[] fileData;
	private String contentType;
	private long fileSize;
	private String thumb;

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
	public int getHashTagId1() {
		return hashTagId1;
	}
	public void setHashTagId1(int hashTagId1) {
		this.hashTagId1 = hashTagId1;
	}
	public int getHashTagId2() {
		return hashTagId2;
	}
	public void setHashTagId2(int hashTagId2) {
		this.hashTagId2 = hashTagId2;
	}
	public int getHashTagId3() {
		return hashTagId3;
	}
	public void setHashTagId3(int hashTagId3) {
		this.hashTagId3 = hashTagId3;
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
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}


}
