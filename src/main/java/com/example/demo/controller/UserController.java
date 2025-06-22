package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Prefecture;
import com.example.demo.service.PrefectureService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/advanced.spring.org/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PrefectureService prefectureService;
	
	/**
	 * 利用者一覧を表示する
	 * @param model 共用のデータ置き場
	 * @return Thymeleafテンプレート名：pages/users/list.html
	 */
	@GetMapping("/list")
	public String index(
			@RequestParam(defaultValue = "") String prefectureCode,
			Model model) {
		// 都道府県選択用都道府県リストを取得
		List<Prefecture> prefectureList = prefectureService.getAllPrefectures();
		
		// リクエストパラメータによる処理の分岐
		List<UserDTO> list = null;
		if (!prefectureCode.isEmpty()) {
			// 都道府県別利用者検索
			list = userService.getByPrefecture(prefectureCode);
		} else {
			// すべての利用者を取得
			list = userService.getAllUsers();
		}
		
		// 各リストを共用のデータ置き場に登録
		model.addAttribute("users", list);
		model.addAttribute("prefectures", prefectureList);
		model.addAttribute("prefectureCode", prefectureCode);
		// 画面遷移
		return "pages/users/list";
	}
}
