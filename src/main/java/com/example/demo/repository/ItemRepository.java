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

}
