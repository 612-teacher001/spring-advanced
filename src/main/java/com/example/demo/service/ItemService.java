package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

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
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"))
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	/**
	 * カテゴリに合致する消費員を取得して表示用商品リストを返す
	 * @param categoryCode 検索対象商品カテゴリコード
	 * @return ItemDTOを要素とする表示用商品リスト
	 */
	public List<ItemDTO> getItemsByCategory(Integer categoryCode) {
		return repository.findByCategoryCodeOrderById(categoryCode)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<ItemDTO> getItemByKeyword(String keyword) {
		return repository.findByNameContainingOrderById(keyword)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<ItemDTO> getItemsByPriceLower(Integer minPrice) {
		return repository.findByPriceGreaterThanEqualOrderByPrice(minPrice)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<ItemDTO> getItemsByPriceInRange(Integer minPrice, Integer maxPrice) {
		return repository.findByPriceBetweenOrderByPrice(minPrice, maxPrice)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<ItemDTO> getItemsByPriceUpper(Integer maxPrice) {
		return repository.findByPriceLessThanEqualOrderByPrice(maxPrice)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
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
