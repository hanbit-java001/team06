package com.hanbit.team06.core.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team06.core.dao.GalleryDAO;
import com.hanbit.team06.core.vo.GalleryVO;

@Service
public class GalleryService {

	 	@Autowired
	 	private GalleryDAO memberDAO;

	 	public GalleryVO addImage(GalleryVO imageList) {

	 		return imageList;
	 	}

	 	public ArrayList<GalleryVO> listImages(GalleryVO imageList) {

	 		return ArrayList<GalleryVO>;
	 	}
}
