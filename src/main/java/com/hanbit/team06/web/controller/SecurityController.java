package com.hanbit.team06.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.team06.core.service.SecurityService;
import com.hanbit.team06.core.session.Session;
import com.hanbit.team06.core.session.SessionHelpler;
import com.hanbit.team06.core.vo.MemberVO;

@Controller
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value="/api/security/login", method=RequestMethod.POST)
	@ResponseBody
	public Map login(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		MemberVO member = securityService.getValidMember(email, password);

		Session session = SessionHelpler.getSession();
		session.setLoggedIn(true);
		session.setMemberId(member.getMemberId());
		session.setEmail(email);
		session.setName(member.getMemberName());

		Map result = new HashMap();
		result.put("name", member.getMemberName());

		return result;
	}

	@RequestMapping(value="/api/security/naverlogin", method=RequestMethod.POST)
	@ResponseBody
	public Map naverLogin(@RequestParam("email") String email){
		MemberVO member = securityService.getNaverMember(email);

		Session session = SessionHelpler.getSession();
		session.setLoggedIn(true);
		session.setMemberId(member.getMemberId());
		session.setEmail(member.getMemberEmail());

		Map result = new HashMap();
		result.put("email", member.getMemberEmail());

		return result;
	}

	@RequestMapping("/api/security/isLoggedIn")
	@ResponseBody
	public Map isLoggedIn() {

		Map result = new HashMap();
		Session session = SessionHelpler.getSession();

		if (!session.isLoggedIn()) {
			result.put("name", "");
		}
		else {
			result.put("name", session.getName());
		}

		return result;
	}

	@RequestMapping("/security/logout")
	public void logout(HttpServletResponse response) throws Exception {

		Session session = SessionHelpler.getSession();
		session.logout();

		response.sendRedirect("/home");
	}

}
