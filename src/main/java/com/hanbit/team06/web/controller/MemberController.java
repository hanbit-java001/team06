package com.hanbit.team06.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanbit.team06.core.service.MemberService;
import com.hanbit.team06.core.vo.MemberVO;
import com.hanbit.team06.web.controller.MemberController;

@Controller
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping("/member/join")
	public String join() {

		return "member/join";
	}

	@RequestMapping(value = "/api/member/join", method = RequestMethod.POST)
	@ResponseBody
	public Map doJoin(MultipartHttpServletRequest request) throws Exception {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

			MemberVO member = new MemberVO();
			member.setName(name);
			member.setEmail(email);
			member.setPassword(password);

			memberService.joinMember(member);

		Map result = new HashMap();
		result.put("name", name);

		return result;
	}

}