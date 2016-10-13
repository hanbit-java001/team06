package com.hanbit.team06.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanbit.team06.core.service.FileService;
import com.hanbit.team06.core.service.GalleryService;
import com.hanbit.team06.core.vo.FileVO;
import com.hanbit.team06.core.vo.GalleryVO;

@Controller
public class GalleryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private GalleryService galleryService;

	@Autowired
	private FileService fileService;

	@RequestMapping("/gallery/main")
	public String main() {

		return "gallery/main";
	}
//	/gallery/upLoad
	@RequestMapping("WEB-INF/jsp/gallery/upLoad.jsp")
	public String update() {

		return "gallery/upLoad";
	}

	@RequestMapping(value = "/api/gallery/upLoad", method = RequestMethod.POST)
	@ResponseBody
	public Map doJoin(MultipartHttpServletRequest request) throws Exception {

		String photoName = request.getParameter("photoName");
		String photoDate = request.getParameter("photoDate");
		String photoRes1 = request.getParameter("photoRes1");
		String photoRes2 = request.getParameter("photoRes2");
		String memberId = request.getParameter("memberId");
		String fileId = "";

		Iterator<String> paramNames = request.getFileNames();

		if (paramNames.hasNext()) {
			String paramName = paramNames.next();

			MultipartFile file = request.getFile(paramName);

			FileVO fileVO = new FileVO();
			fileVO.setContentType(file.getContentType());
			fileVO.setFileSize(file.getSize());
			fileVO.setFileName(file.getName());
			fileVO.setFileData(file.getBytes());

			fileId = fileService.storeFile(fileVO);
		}

		try {
			GalleryVO gallery = new GalleryVO();
			gallery.setPhotoName(photoName);
			gallery.setPhotoDate(photoDate);
			gallery.setPhotoRes1(Integer.parseInt(photoRes1));
			gallery.setPhotoRes2(Integer.parseInt(photoRes2));
//			gallery.setPhotoPath(fileId);
			gallery.setMemberId(Integer.parseInt(memberId));

			galleryService.addPhoto(gallery);
		} catch (Exception e) {
			if (StringUtils.isNotBlank(fileId)) {
				fileService.removeFile(fileId);
			}

			throw new RuntimeException(e.getMessage(), e);
		}

		Map result = new HashMap();
		result.put("photoName", photoName);

		return result;
	}
}
