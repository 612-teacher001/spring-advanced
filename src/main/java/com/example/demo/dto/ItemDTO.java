package com.example.demo.dto;

import lombok.Data;

/**
 * 商品一覧表示用DTO
 */
@Data
public class ItemDTO {
	
	/**
	 * フィールド
	 */
	private Integer id;      // 商品ID
	private String category; // 商品カテゴリ
	private String name;     // 商品名
	private Integer price;   // 価格
	
}
