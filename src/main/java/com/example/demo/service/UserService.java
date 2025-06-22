package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	/**
	 * すべての利用者を取得して表示用利用者リストを返す
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getAllUsers() {
		return repository.findAllByOrderById()
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	/**
	 * 都道府県別の利用者を取得して表示用利用者リストを返す
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getByPrefecture(String prefectureCode) {
		return repository.findByPrefectureCodeOrderById(prefectureCode)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	/**
	 * 利用者エンティティを利用者DTOに変換する
	 * @param user 利用者エンティティ
	 * @return 利用者DTO
	 */
	private UserDTO convertToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setRole(user.getRole().getName());
		dto.setName(user.getName());
		dto.setPrefecture(user.getPrefecture().getName());
		dto.setAddress(user.getAddress());
		dto.setPhone(user.getPhone());
		dto.setEmail(user.getEmail());
		dto.setBirthday(user.getBirthday().toString());
		dto.setPassword(user.getPassword());
		return dto;
	}
	
}
