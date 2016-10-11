package com.hanbit.team06.web.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.team06.core.service.FileService;
import com.hanbit.team06.core.vo.FileVO;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping("/poroporo/files/{fileId}")
	@ResponseBody
	public void getFile(@PathVariable("fileId") String fileId,
			HttpServletResponse response) throws Exception {

		FileVO fileVO = fileService.getFile(fileId);

		response.setContentType(fileVO.getContentType());
		response.setContentLengthLong(fileVO.getFileSize());

		OutputStream outputStream = response.getOutputStream();
		outputStream.write(fileVO.getFileData());
		outputStream.close();
	}

}
