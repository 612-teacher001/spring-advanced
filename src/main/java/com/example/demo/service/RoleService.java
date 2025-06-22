package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository repository;
	
	/**
	 * すべての権限の表示用権限リストを返す
	 * @return 権限リスト
	 */
	public List<Role> getAllRoles() {
		List<Role> list = repository.findAllByOrderById();
		return list;
	}
	
}
