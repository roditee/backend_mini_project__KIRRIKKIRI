package com.boot.backendMiniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("/productDetailView")
	public String productDetailView() {
		return "/productDetailView";
	}
}