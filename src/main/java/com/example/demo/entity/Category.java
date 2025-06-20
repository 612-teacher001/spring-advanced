package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "m_categories")
public class Category {
	
	/**
	 * フィールド
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code; // カテゴリコード
	private String name;  // カテゴリ名

	/**
	 * Categoryエンティティが所有しない（非所有側）の@OneToManyリレーション
	 * mappedByには、Itemエンティティ内でCategoryを参照するフィールド名「category」を指定する。
	 * この設定により、Categoryから関連するItemの一覧を取得できる。
	 * リレーションの所有者はItem側（外部キーを持つ側）となるため、Category側はDBのリレーションを直接管理しない。
	 * ただし、この取得方法は単純にフィールド取得という意味であってカテゴリ検索とは意味が異なるので注意すること。
	 */
	@OneToMany(mappedBy = "category")
	private List<Item> items = new ArrayList<Item>(); // カテゴリに紐づいた商品リスト
	
}
