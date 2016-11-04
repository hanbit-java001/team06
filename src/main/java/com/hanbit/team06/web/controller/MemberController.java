package com.hanbit.team06.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanbit.team06.core.service.MemberService;
import com.hanbit.team06.core.vo.MemberVO;

@Controller
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping("/member/join")
	public String join() {

		return "member/join";
	}

	@RequestMapping(value="/api/member/join", method=RequestMethod.POST)
	@ResponseBody
	public Map doJoin(MultipartHttpServletRequest request) throws Exception {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			MemberVO member = new MemberVO();
			member.setMemberName(name);
			member.setMemberEmail(email);
			member.setMemberPw(password);

			memberService.joinMember(member);
		}
		catch (Exception e) {

			throw new RuntimeException(e.getMessage(), e);
		}

		Map result = new HashMap();
		result.put("name", name);

		return result;
	}

	@RequestMapping("/members")
	public String listMember() {

		return "member/list";
	}

	@RequestMapping("/api/member/list")
	@ResponseBody
	public Map<String, Object> listMembers(@RequestParam("page") int page) {
		Map<String, Object> pagingMembers = new HashMap<>();

		List<MemberVO> members = memberService.getMembers(page);
		int totalCount = memberService.getTotalMembers();

		pagingMembers.put("totalCount", totalCount);
		pagingMembers.put("members", members);

		return pagingMembers;
	}

}
