package com.hanbit.team06.web.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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

	@Autowired
	private GalleryService galleryService;

	@RequestMapping("/gallery/main")
	public String main() {

		return "gallery/main";
	}

	@RequestMapping("/gallery/upLoad")
	public String update() {

		return "gallery/upLoad";
	}

	@RequestMapping("/gallery/up")
	public String up() {

		return "gallery/up";
	}

//	@RequestMapping("/poroporo/file/{photoId}")
//	@ResponseBody
//	public void getFile(@PathVariable("photoId") int photoId, HttpServletResponse response) throws Exception {
//
//		GalleryVO galleryVO = GalleryService.getFile(photoId);
//
//		response.setContentType(galleryVO.getContentType());
//		response.setContentLengthLong(galleryVO.getFileSize());
//
//		OutputStream outputStream = response.getOutputStream();
//		outputStream.write(galleryVO.getFileData());
//		outputStream.close();
//	}
//
//	@RequestMapping(value = "/api/gallery/up", method = RequestMethod.POST)
//	@ResponseBody
//	public Map doJoin(MultipartHttpServletRequest request) throws Exception {
//
//		String hachTagId1 = request.getParameter("hachTagId1");
//		String hachTagId2 = request.getParameter("hachTagId2");
//		String hachTagId3 = request.getParameter("hachTagId3");
//		int photoId = 0;
//
//		Iterator<String> paramNames = request.getFileNames();
//
//		try {
//			if (paramNames.hasNext()) {
//				String paramName = paramNames.next();
//
//				MultipartFile file = request.getFile(paramName);
//
//				GalleryVO galleryVO = new GalleryVO();
//				galleryVO.setContentType(file.getContentType());
//				galleryVO.setFileSize(file.getSize());
//				galleryVO.setPhotoName(file.getName());
//				galleryVO.setFileData(file.getBytes());
//				// galleryVO.setHachTagId1(Integer.parseInt(hachTagId1));
//				// galleryVO.setHachTagId2(Integer.parseInt(hachTagId2));
//				// galleryVO.setHachTagId3(Integer.parseInt(hachTagId3));
//
//				photoId = galleryService.addPhoto(galleryVO);
//			}
//		} catch (Exception e) {
//			galleryService.removeFile(photoId);
//			throw new RuntimeException(e.getMessage(), e);
//		}
//
//		Map result = new HashMap();
//		result.put("photoName", paramName);
//
//		return result;
//
//	}
}
