package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advanced.spring.org")
public class IndexController {
	
	/**
	 * メニュページを表示する
	 * @return Thymeleafテンプレート名：pages/menu.html
	 */
	@GetMapping("/menu")
	public String menu() {
		return "pages/menu";
	}
	
	/**
	 * インデックスページを表示する
	 * @return Thymeleafテンプレート名：index.html
	 */
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
}
