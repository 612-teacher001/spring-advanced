package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**
	 * カテゴリ検索
	 * @param categoryCode 検索対象のカテゴリコード
	 * @return 商品エンティティリスト
	 */
	List<Item> findByCategoryCodeOrderById(Integer categoryCode);

	/**
	 * 商品名のキーワード検索
	 * @param keyword 検索キーワード：商品名に含まれる文字列
	 * @return 商品エンティティリスト
	 */
	List<Item> findByNameContainingOrderById(String keyword);

}
