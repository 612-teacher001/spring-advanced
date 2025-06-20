package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

/**
 * 商品に関する処理を提供するServiceクラス
 */
@Service
public class ItemService {
	
	@Autowired
	ItemRepository repository;
	
	/**
	 * すべての商品を取得して表示用商品リストを返す
	 * @return ItemDTOを要素とする表示用商品リスト
	 */
	public List<ItemDTO> getAllItem() {
		List<Item> itemList = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		for (Item item : itemList) {
			ItemDTO dto = convertToDTO(item);
			list.add(dto);
		}
		return list;
	}

	/**
	 * 商品エンティティを商品DTOに変換する
	 * @param item 商品ティティ
	 * @return 商品DTO
	 */
	private ItemDTO convertToDTO(Item item) {
		ItemDTO dto = new ItemDTO();
		dto.setId(item.getId());
		dto.setCategory(item.getCategory().getName());
		dto.setName(item.getName());
		dto.setPrice(item.getPrice());
		return dto;
	}

}
