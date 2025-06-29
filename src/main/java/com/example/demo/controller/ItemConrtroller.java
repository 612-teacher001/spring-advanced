package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Category;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;


@Controller
@RequestMapping("/advanced.spring.org/items")
public class ItemConrtroller {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemService itemService;
	
	/**
	 * 商品一覧画面を表示する
	 * @param model 共用のデータ置き場
	 * @return Thymeleafテンプレート名：pages/items/list.html
	 */
	@GetMapping("/list")
	public String index(
			@RequestParam(defaultValue = "") Integer minPrice,
			@RequestParam(defaultValue = "") Integer maxPrice,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") Integer categoryCode,
			Model model) {
		// カテゴリリンク用のカテゴリリストを取得
		List<Category> categoryList = categoryService.getAllCategories();
		
		// 表示用ItemDTOを要素とする商品リストの初期化
		List<ItemDTO> list = null;
		// リクエストパラメータによる処理の分岐
		if (categoryCode != null) {
			// categoryCodeキーが非nullの場合：カテゴリ検索
			list = itemService.getItemsByCategory(categoryCode);
		} else if (!keyword.isEmpty()) {
			// keywordキーが非nullの場合：商品名のキーワード検索
			list = itemService.getItemByKeyword(keyword);
		} else if (minPrice != null && maxPrice == null) {
			// 最小価格が指定されている場合
			list = itemService.getItemsByPriceLower(minPrice);
		} else if (minPrice != null && maxPrice != null) {
			// 最小価格と最大価格が指定されている場合
			list = itemService.getItemsByPriceInRange(minPrice, maxPrice);
		} else if (maxPrice != null) {
			// 最大価格が指定されている場合
			list = itemService.getItemsByPriceUpper(maxPrice);
		} else {
			// categryCodeキーがnullの場合：全商品検索
			list = itemService.getAllItem();
		}
		
		// 各リストを共用のデータ置き場に登録
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", list);
		model.addAttribute("categoryCode", categoryCode);
		model.addAttribute("keyword", keyword);
		model.addAttribute("minPrice", minPrice);
		model.addAttribute("maxPrice", maxPrice);
		// 画面遷移
		return "pages/items/list";
	}
	
}
