package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Prefecture;
import com.example.demo.repository.PrefectureRepository;

@Service
public class PrefectureService {
	
	@Autowired
	PrefectureRepository repository;

	/**
	 * すべての都道府県の表示用都道府県リストを返す
	 * @return 都道府県リスト
	 */
	public List<Prefecture> getAllPrefectures() {
		List<Prefecture> list = repository.findAllByOrderByCode();
		return list;
	}

}
