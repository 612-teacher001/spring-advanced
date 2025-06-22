package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/advanced.spring.org/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 利用者一覧を表示する
	 * @param model 共用のデータ置き場
	 * @return Thymeleafテンプレート名：pages/users/list.html
	 */
	@GetMapping("/list")
	public String index(Model model) {
		// すべての利用者を取得
		List<User> list = userService.getAllUsers();
		// 各リストを共用のデータ置き場に登録
		model.addAttribute("users", list);
		// 画面遷移
		return "pages/users/list";
	}
}
