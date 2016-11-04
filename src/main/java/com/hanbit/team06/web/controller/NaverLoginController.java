package com.hanbit.team06.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaverLoginController {

	@RequestMapping("/naverIdLogin")
	public String welcome() {

		return "naverIdLogin";
	}


}
