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

	@RequestMapping("/home/home")
	public String welcome() {

		return "home/home";
	}



}
