package com.hanbit.team06.web.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanbit.team06.core.service.GalleryService;
import com.hanbit.team06.core.vo.GalleryVO;

@Controller
public class GalleryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	private static final String HOST_IP = "203.236.209.189:8282/";

	@Autowired
	private GalleryService galleryService;

	@RequestMapping("/gallery/upLoad")
	public String upLoadWin() {

		return "gallery/upLoad";
	}

	@RequestMapping("/member/myPhoto")
	public String myPhoto() {

		return "member/myPhoto";
	}

	@RequestMapping("/poroporo/thumbnail/T{photoName}")
	@ResponseBody
	public void getFile(@PathVariable("photoName") String photoName, HttpServletResponse response) throws Exception {

		GalleryVO galleryVO = galleryService.getFile(photoName);

		response.setContentType(galleryVO.getContentType());
		//response.setContentLengthLong(galleryVO.getFileSize());

		OutputStream outputStream = response.getOutputStream();
		outputStream.write(galleryVO.getFileData());
		outputStream.close();
		response.flushBuffer();
	}

	@RequestMapping(value = "/hash/gallery/upLoad", method = RequestMethod.POST)
	@ResponseBody
	public List<String> upLoadHash(HttpServletRequest request) {
		List<String> hashList = galleryService.getHashList();
		return hashList;
	}

	@RequestMapping(value = "/api/gallery/upLoad", method = RequestMethod.POST)
	@ResponseBody
	public List<String> upLoad(MultipartHttpServletRequest request) {
//		int photoId = 0;
		GalleryVO galleryVO = new GalleryVO();
		String photoName = "";
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileParamNames = request.getFileNames();
		List<String> hashList = new ArrayList<String>();
		List<Integer> hashId = new ArrayList<Integer>();

		Enumeration<String> paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramN = request.getParameter(paramName);

			hashList = galleryService.generateHashtag(paramN);
			galleryService.insertHashtag(hashList);

			hashId = galleryService.selectHashtagId(hashList);

			galleryVO.setHashTagId1(hashId.get(0));
			galleryVO.setHashTagId2(hashId.get(1));
			galleryVO.setHashTagId3(hashId.get(2));

			try {
				String fileparamName = fileParamNames.next();
				MultipartFile file = request.getFile(fileparamName);

				galleryVO.setContentType(file.getContentType());
				galleryVO.setFileSize(file.getSize());
				galleryVO.setPhotoName(file.getName());
				galleryVO.setFileData(file.getBytes());

				photoName = galleryService.storePhoto(galleryVO);
//				photoId = galleryDAO.selectNextPhotoId();

				fileList.add(photoName);

			} catch (Exception e) {
//				galleryService.removeFile(photoId);
				System.out.println("오률ㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return fileList;
	}

	@RequestMapping("/gallery/galleryList")
	public String gallery() {

		return "gallery/galleryList";
	}

	@RequestMapping("/api/gallery/galleryList")
	@ResponseBody
	public Map<String, Object> mapListPhotos() {
		Map<String, Object> galleryMap = new HashMap<>();

		List<GalleryVO> galleryList = galleryService.getPhotoList();
		int totalCount = galleryService.getTotalPhotos();

		galleryMap.put("totalCount", totalCount);
		galleryMap.put("galleryList", galleryList);

		return galleryMap;
	}

	@RequestMapping("/api/sumLike/gallery/galleryList")
	@ResponseBody
	public int sumPhotoLike(int photoId) {
		int sumLike = galleryService.sumLike(photoId);
		return sumLike;
	}

	@RequestMapping("/api/sumRead/gallery/galleryList")
	@ResponseBody
	public int sumReadCount(int photoId) {
		int sumReadCount = galleryService.sumReadCount(photoId);
		return sumReadCount;
	}

}
