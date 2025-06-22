package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	/**
	 * すべての権限の表示用権限リストを返す
	 * @return 権限リスト
	 */
	List<Role> findAllByOrderById();

}
