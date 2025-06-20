package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;

	/**
	 * すべてのカテゴリを取得してカテゴリリストとして返す
	 * @return カテゴリリスト
	 */
	public List<Category> getAllCategories() {
		List<Category> list = repository.findAll(Sort.by(Sort.Direction.ASC, "code"));
		return list;
	}

}
