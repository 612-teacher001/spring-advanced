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
import com.example.demo.entity.Role;
import com.example.demo.service.PrefectureService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/advanced.spring.org/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PrefectureService prefectureService;
	
	@Autowired
	RoleService roleService;
	
	/**
	 * 利用者一覧を表示する
	 * @param model 共用のデータ置き場
	 * @return Thymeleafテンプレート名：pages/users/list.html
	 */
	@GetMapping("/list")
	public String index(
			@RequestParam(defaultValue = "") String prefectureCode,
			@RequestParam(defaultValue = "") Integer role,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String address,
			@RequestParam(defaultValue = "") Integer offset,
			@RequestParam(defaultValue = "") Integer total,
			Model model) {
		// 都道府県選択用都道府県リストを取得
		List<Prefecture> prefectureList = prefectureService.getAllPrefectures();
		// 権限選択用権限リストを取得
		List<Role> roleList = roleService.getAllRoles();
		
		// リクエストパラメータによる処理の分岐
		List<UserDTO> list = null;
		if (!prefectureCode.isEmpty() && role != null) {
			// 都道府県別権限別利用者検索
			list = userService.getByPrefectureAndRole(prefectureCode, role);
		} else if (!prefectureCode.isEmpty()) {
			// 都道府県別利用者検索
			list = userService.getByPrefecture(prefectureCode);
		} else if (role != null) {
			// 権限別利用者検索
			list = userService.getByRole(role);
		} else {
			if (!name.isEmpty()) {
				if (!address.isEmpty()) {
					// 氏名住所あいまい検索
					list = userService.getByNameAndAddress(name, address);
				} else {
					// 氏名あいまい検索
					list = userService.getByName(name);
				}
			} else {
				if (offset != null) {
					// ページネーション表示
					list = userService.getUserWithLimit(offset);
				} else {
					// すべての利用者を取得
					list = userService.getAllUsers();
				}
			}
		}
		
		// 各リストを共用のデータ置き場に登録
		model.addAttribute("users", list);
		model.addAttribute("prefectures", prefectureList);
		model.addAttribute("prefectureCode", prefectureCode);
		model.addAttribute("roles", roleList);
		model.addAttribute("roleId", role);
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("offset", offset);
		model.addAttribute("totalPage", userService.getTotalPage()); // トータルページ数（表示に必要な画面数）
		
		// 画面遷移
		return "pages/users/list";
	}
}
