package com.hanbit.team06.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.team06.core.session.LoginRequired;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {

		return "home";
	}

<<<<<<< HEAD
	@RequestMapping("/gallery/galleryList2")
	public String galleryList2() {

		return "gallery/galleryList2";
	}

=======
	@RequestMapping("/form")
	public String form() {

		return "form";
	}
>>>>>>> branch 'master' of https://github.com/hanbit-java001/team06.git
}
