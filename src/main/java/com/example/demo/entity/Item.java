package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Integer id;        // 商品番号
	@ManyToOne
	@JoinColumn(name = "category_code")
	private Category category; // カテゴリコード
	private String name;       // 商品名
	private Integer price;     // 価格
	
	/**
	 * カテゴリ名を取得する
	 * @return カテゴリインスタンスがnullではない場合はカテゴリ名、それ以外はnull
	 */
	public String getCategoryName() {
		if (this.category == null) {
			return null;
		}
		return this.category.getName();
	}
	
}
