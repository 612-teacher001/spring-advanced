package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;


@Controller
@RequestMapping("/advanced.spring.org/items")
public class ItemConrtroller {
	
	@Autowired
	ItemRepository itemRepository;
	
	/**
	 * 商品一覧画面を表示する
	 * @param model 共用のデータ置き場
	 * @return Thymeleafテンプレート名：pages/items/list.html
	 */
	@GetMapping("/list")
	public String index(Model model) {
		// itemsテーブルからすべての商品の商品リストを取得
		List<Item> itemList = itemRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		// 表示用ItemDTOを要素とする商品リストに詰替
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		for (Item item : itemList) {
			ItemDTO dto = new ItemDTO();
			dto.setId(item.getId());
			dto.setCategory(item.getCategoryName());
			dto.setName(item.getName());
			dto.setPrice(item.getPrice());
			list.add(dto);
		}
		// 商品リストを共用のデータ置き場に登録
		model.addAttribute("items", list);
		// 画面遷移
		return "pages/items/list";
	}
	
}
