package com.hanbit.team06.core.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
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

	public String storePhoto(GalleryVO galleryVO) {
		String photoName = generateFileName(galleryVO);
		String photoPath = "/poroporo/files/" + photoName;

		try {
			FileUtils.writeByteArrayToFile(new File(photoPath), galleryVO.getFileData());
		}
		catch (IOException e) {
			LOGGER.error(e.getMessage(), e);

			throw new RuntimeException("파일 저장중 문제가 발생하였습니다.");
		}

		galleryVO.setPhotoName(photoName);
		galleryVO.setPhotoPath(photoPath);

		galleryDAO.insertPhoto(galleryVO);

		return photoName;
	}

	private String generateFileName(GalleryVO galleryVO) {
		String seq = String.valueOf(galleryDAO.selectNextPhotoId());
		String photoName = galleryVO.getPhotoName();
//		String fileType =

		String uniqueName = seq + photoName;

		return uniqueName;
	}

	public GalleryVO getFile(String photoName) throws Exception {
		GalleryVO galleryVO = galleryDAO.selectFile(photoName);

		String photoPath = galleryVO.getPhotoPath();
		byte[] fileData = FileUtils.readFileToByteArray(new File(photoPath));

		galleryVO.setFileData(fileData);

		return galleryVO;
	}

	public void removeFile(int photoId) throws Exception {
		GalleryVO galleryVO = galleryDAO.selectPhoto(photoId);

		String photoPath = galleryVO.getPhotoPath();
		FileUtils.forceDelete(new File(photoPath));

		galleryDAO.deletePhoto(photoId);
	}

//	public boolean modifyPhoto(GalleryVO photo) { //�꽭�뀡�뿉�꽌爰쇰궡�꽌 鍮꾧탳

//	}

	public GalleryVO getPhoto(int photoId) {
		return galleryDAO.selectPhoto(photoId);
	}

	public int getTotalPhotos() {
		return galleryDAO.countPhotoList();
	}

	public List<GalleryVO> getPhotoList() {
		List<GalleryVO> photoList = galleryDAO.selectPhotoList();

		return photoList;
	}
}
