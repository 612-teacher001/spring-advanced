package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	/**
	 * 都道府県別権限別利用者を利用者IDの昇順に取得する
	 * SELECT * FROM users WHERE prefecture = :prefecctureCode AND role = :role
	 * @param prefectureCode 検索対象都道府県コード
	 * @param role 検索対象権限コード
	 * @return 利用者エンティティリスト
	 */
	List<User> findByPrefectureCodeAndRoleIdOrderById(String prefectureCode, Integer role);

	/**
	 * 権限別利用者を利用者IDの昇順に取得する
	 * SELECT * FROM users WHERE role = :role ORDER BY id
	 * @param role 検索対象権限コード
	 * @return 利用者エンティティリスト
	 */
	List<User> findByRoleIdOrderById(Integer role);

	/**
	 * 氏名あいまい検索で利用者IDの昇順に取得する
	 * @param name 検索氏名
	 * @return 利用者エンティティリスト
	 */
	List<User> findByNameContainingOrderById(String name);

	/**
	 * 氏名住所あいまい検索で利用者IDの昇順に取得する
	 * @param name 検索氏名
	 * @param addresss 検索住所
	 * @return 利用者エンティティリスト
	 */
	List<User> findByNameContainingAndAddressContainingOrderById(String name, String address);

	Page<User> findAll(Pageable pageable);
}
