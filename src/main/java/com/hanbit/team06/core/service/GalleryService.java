package com.hanbit.team06.core.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.team06.core.dao.GalleryDAO;
import com.hanbit.team06.core.session.Session;
import com.hanbit.team06.core.session.SessionHelpler;
import com.hanbit.team06.core.vo.GalleryVO;

@Service
public class GalleryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private GalleryDAO galleryDAO;

	public String storePhoto(GalleryVO galleryVO) throws Exception {
		String photoName = generateFileName(galleryVO); // 시퀸스붙인.jpg
		int pathMiddle = photoName.lastIndexOf(".");
		String photoNameF = photoName.substring(0, pathMiddle);
		String photoPath = "/poroporo/files/" + photoName;

		Session session = SessionHelpler.getSession();
		int memberId = session.getMemberId();

		try {
			FileUtils.writeByteArrayToFile(new File(photoPath), galleryVO.getFileData());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);

			throw new RuntimeException("파일 저장중 문제가 발생하였습니다.");
		}

		galleryVO.setMemberId(memberId);
		galleryVO.setPhotoName(photoNameF); // 순수파일이름
		galleryVO.setPhotoPath(photoPath); // 경로.jpg
		galleryVO.setThumb(getThumbnailG(galleryVO)); // 섬네일경로.jpg
		galleryVO.setPhotoRes1(fileRes(galleryVO).getPhotoRes1());
		galleryVO.setPhotoRes2(fileRes(galleryVO).getPhotoRes2());

		galleryDAO.insertPhoto(galleryVO);

		return photoName;
	}

	public GalleryVO fileRes(GalleryVO galleryVO) throws Exception {
		File origin_file = new File(galleryVO.getPhotoPath());
		BufferedImage image = ImageIO.read(origin_file);
		String width = image.getWidth(null) + "";
		String height = image.getHeight(null) + "";
		galleryVO.setPhotoRes1(width);
		galleryVO.setPhotoRes2(height);

		return galleryVO;
	}

	public String getThumbnailG(GalleryVO galleryVO) {

		int thumbnail_width = 315;
		int thumbnail_height = 212;
		String thumbnailPath = "/poroporo/thumbnail/T" + galleryVO.getPhotoName() + ".jpg";
		File origin_file_name = new File(galleryVO.getPhotoPath());
		File thumb_file_name = new File(thumbnailPath);
		try {
			BufferedImage buffer_original_image = ImageIO.read(origin_file_name);
			BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height,
					BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = buffer_thumbnail_image.createGraphics();
			graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
			ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
		} catch (Exception e) {
			System.out.println("썸네일 생성오류");
			e.printStackTrace();
		}
		return thumbnailPath;
	}

	private String generateFileName(GalleryVO galleryVO) {
		String seq = String.valueOf(galleryDAO.selectNextPhotoId());
		String photoName = galleryVO.getPhotoName();

		String uniqueName = seq + photoName;

		return uniqueName;
	}

	public List<String> generateHashtag(String param) {
		String hashtag = param;
		List<String> hashList = new ArrayList<String>();
		String[] hashArray;
		hashArray = hashtag.split(",");
		for (int i = 0; i < hashArray.length; i++) {
			hashList.add(hashArray[i]);
		}
		return hashList;
	}

	public void insertHashtag(List<String> param) {
		List<String> hashList = param;

		for (int i = 0; i < hashList.size(); i++) {
			String hash = hashList.get(i);
			String hashv = "";
			hashv = galleryDAO.selectHashtagS(hash);
			if (hashv == null || hashv.equals("")) {
				galleryDAO.insertHash(hash);
			}
		}
	}

	public List<Integer> selectHashtagId(List<String> hash) {
		List<Integer> hashId = new ArrayList<Integer>();

		for (String hashs : hash) {
			hashId.add(galleryDAO.selectHashtagI(hashs));
		}

		return hashId;
	}

	public int sumLike(int photoId){
		int likeNum = galleryDAO.sumPhotoLike();
		return likeNum;
	}

	public int sumReadCount(int photoId){
		int readCountNum = galleryDAO.sumReadCount();
		return readCountNum;
	}

	public GalleryVO getFile(String photoName) throws Exception {
		GalleryVO galleryVO = galleryDAO.selectFile(photoName);

		String photoPath = galleryVO.getThumb();
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

	// public boolean modifyPhoto(GalleryVO photo) { //�꽭�뀡�뿉�꽌爰쇰궡�꽌 鍮꾧탳

	// }

//	public GalleryVO getPhoto(int photoId) {
//		return galleryDAO.selectPhoto(photoId);
//	}

	public GalleryVO getPhoto(int photoId) {
		GalleryVO galleryVO = galleryDAO.selectPhoto(photoId);
		List<Integer> hashList = new ArrayList<Integer>();
		hashList.add(galleryVO.getHashTagId1());
		hashList.add(galleryVO.getHashTagId2());
		hashList.add(galleryVO.getHashTagId3());

		List<String> hashWords = galleryDAO.selectHashtagIS(hashList);
		galleryVO.setHashTagWord1(hashWords.get(0));
		galleryVO.setHashTagWord2(hashWords.get(1));
		galleryVO.setHashTagWord3(hashWords.get(2));
		return galleryVO;
	}

	public List<GalleryVO> getFindPhotoList(String findWord) {
		Integer hashId = galleryDAO.selectHashtagI(findWord); //스플릿안해줌

		if (hashId == null) {
			hashId = 0;
		}

		List<GalleryVO> photoList = galleryDAO.selectPhotoFind(hashId);
		return photoList;
	}

	public int getTotalPhotos() {
		return galleryDAO.countPhotoList();
	}

	public List<GalleryVO> getPhotoList() {
		List<GalleryVO> photoList = galleryDAO.selectPhotoList();
		return photoList;
	}

	public List<String> getHashList() {
		List<String> hashList = galleryDAO.allHashList();
		return hashList;
	}
}
