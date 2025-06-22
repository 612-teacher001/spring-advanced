package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	/**
	 * すべての利用者を取得して利用者リストを返す
	 * @return 利用者エンティティリスト
	 */
	public List<User> getAllUsers() {
		List<User> list = repository.findAllByOrderById();
		return list;
	}
	
}
