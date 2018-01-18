package com.app.mvc.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@RequestMapping("/index")
	public String display() {

		return "homePage/homePage";
	}
}
