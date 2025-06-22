package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * すべての利用者を利用者IDの昇順に取得する
	 * SELECT * FROM users ORDER BY id
	 * @return 利用者エンティティリスト
	 */
	List<User> findAllByOrderById();

	/**
	 * 都道府県別利用者を利用者IDの照準に取得する
	 * SELECT * FROM users WHERE prefecture = :prefectureCode ORDER BY id 
	 * @param prefectureCode 検索対象都道府県コード
	 * @return 利用者エンティティリスト
	 */
	List<User> findByPrefectureCodeOrderById(String prefectureCode);

}
