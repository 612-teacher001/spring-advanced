package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * itemsテーブルの1レコードを管理するクラス
 */
@Data
@Entity
@Table(name = "items")
public class Item {
	
	/**
	 * フィールド
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;           // 商品番号
	@Column(name = "category_code")
	private Integer categoryCode; // カテゴリコード
	private String name;          // 商品名
	private Integer price;        // 価格
	
}
