package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * トップページを表示する
 */
@Controller
@RequestMapping("/advanced.spring.org")
public class IndexController {
	
	/**
	 * インデックスページを表示する
	 * @return Thymeleafテンプレート名：index.html
	 */
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
}
