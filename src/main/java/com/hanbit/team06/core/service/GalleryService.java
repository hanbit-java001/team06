package com.hanbit.team06.core.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team06.core.dao.GalleryDAO;
import com.hanbit.team06.core.vo.GalleryVO;

@Service
public class GalleryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private GalleryDAO galleryDAO;

	public String addImage(GalleryVO photo) {
		int imageId = galleryDAO.selectNextPhotoId();
		photo.setPhotoId(photoId);

		galleryDAO.insertPhoto(photo);

		return photo.getPhotoName();
	}

	public ArrayList<GalleryVO> getImages(int photoId) {

		return galleryDAO.selectGallery(photoId);
	 	}
}
