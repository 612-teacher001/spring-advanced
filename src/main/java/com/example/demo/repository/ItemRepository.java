package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**
	 * カテゴリ検索
	 * SELECT * FROM items WHERE category_code = :categoryCode ORDER BY id
	 * @param categoryCode 検索対象のカテゴリコード
	 * @return 商品エンティティリスト
	 */
	List<Item> findByCategoryCodeOrderById(Integer categoryCode);

	/**
	 * 商品名のキーワード検索
	 * SELECT * FROM items WHERE name LIKE %:keyword% ORDER BY id
	 * @param keyword 検索キーワード：商品名に含まれる文字列
	 * @return 商品エンティティリスト
	 */
	List<Item> findByNameContainingOrderById(String keyword);


	/**
	 * 最小価格より高い価格の商品を取得する
	 * SELECT * FROM items WHERE price >= :minPrice ORDER BY price
	 * @param minPrice 最小価格
	 * @return 商品エンティティリスト
	 */
	List<Item> findByPriceGreaterThanEqualOrderByPrice(Integer minPrice);

	/**
	 * 最小価格と最大価格の範囲に入っている価格の商品を取得する
	 * SELECT * FROM items WHERE price BETWEEN :minPrice AND>= :maxPrice ORDER BY price
	 * @param minPrice 最小価格
	 * @param maxPrice 最大価格
	 * @return 商品エンティティリスト
	 */
	List<Item> findByPriceBetweenOrderByPrice(Integer minPrice, Integer maxPrice);

	/**
	 * 最大価格より低い価格の商品を取得する
	 * SELECT * FROM items WHERE price <= :maxPrice ORDER BY price
	 * @param maxPrice 最大価格
	 * @return 商品エンティティリスト
	 */
	List<Item> findByPriceLessThanEqualOrderByPrice(Integer maxPrice);

}
