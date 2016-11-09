package com.hanbit.team06.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {

		return "home";
	}

	@RequestMapping("/gallery/galleryList2")
	public String galleryList2() {

		return "gallery/galleryList2";
	}

	@RequestMapping("/gallery/up")
	public String gup() {

		return "gallery/up";
	}

	@RequestMapping("/gallery/up2")
	public String gup2() {

		return "gallery/up2";
	}

	@RequestMapping("/gallery/up3")
	public String gup3() {

		return "gallery/up3";
	}

}
