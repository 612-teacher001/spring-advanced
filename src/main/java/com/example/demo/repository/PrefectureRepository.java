package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Prefecture;

public interface PrefectureRepository extends JpaRepository<Prefecture, String> {

	/**
	 * 都道府県コードの昇順で並べ替えた都道府県リストを取得する
	 * SELECT * FROM m_prefectiures ORDER BY code
	 * @return 都道府県リスト
	 */
	List<Prefecture> findAllByOrderByCode();

}
