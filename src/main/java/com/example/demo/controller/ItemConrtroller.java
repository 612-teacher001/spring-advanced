package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ItemDTO;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;


@Controller
@RequestMapping("/advanced.spring.org/items")
public class ItemConrtroller {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemService itemService;
	
	/**
	 * 商品一覧画面を表示する
	 * @param model 共用のデータ置き場
	 * @return Thymeleafテンプレート名：pages/items/list.html
	 */
	@GetMapping("/list")
	public String index(Model model) {
		// 表示用ItemDTOを要素とする商品リストを取得
		List<ItemDTO> list = itemService.getAllItem();
		// 商品リストを共用のデータ置き場に登録
		model.addAttribute("items", list);
		// 画面遷移
		return "pages/items/list";
	}
	
}
