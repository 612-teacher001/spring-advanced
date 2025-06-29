package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	/**
	 * クラス定数
	 */
	private static final Integer DEFAULT_PAGE_LIMIT = 10; // １画面内レコード表示数
	
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
	 * @param prefectureCode 都道府県コード
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getByPrefecture(String prefectureCode) {
		return repository.findByPrefectureCodeOrderById(prefectureCode)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	/**
	 * 都道府県別権限別の表示用使用者リストを返す
	 * @param prefectureCode 都道府県コード
	 * @param role 権限コード
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getByPrefectureAndRole(String prefectureCode, Integer role) {
		return repository.findByPrefectureCodeAndRoleIdOrderById(prefectureCode, role)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	/**
	 * 権限別の表示用利用者リストを返す
	 * @param role 権限コード
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getByRole(Integer role) {
		return repository.findByRoleIdOrderById(role)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	/**
	 * 氏名あいまい検索
	 * @param name 検索氏名
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getByName(String name) {
		return repository.findByNameContainingOrderById(name)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	/**
	 * 氏名住所あいまい検索
	 * @param name 検索氏名
	 * @param address 検索時住所
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getByNameAndAddress(String name, String address) {
		return repository.findByNameContainingAndAddressContainingOrderById(name, address)
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	/**
	 * ページネーション表示用利用者リストを取得する
	 * @param offset 全レコード中の相対的表示位置（表示ページ）
	 * @return 利用者DTOを要素とする表示用利用者リスト
	 */
	public List<UserDTO> getUserWithLimit(Integer offset) {
		PageRequest pageRequest = PageRequest.of(offset, DEFAULT_PAGE_LIMIT, Sort.by("id").ascending());
		Page<User> page = repository.findAll(pageRequest);
		return page.stream()
				   .map(this::convertToDTO)
				   .collect(Collectors.toList());
	}

	/**
	 * 表示用ページ数を取得する
	 * @return 表示用ページ数
	 */
	public Long getTotalPage() {
		return (long) Math.ceil((double) repository.count() / DEFAULT_PAGE_LIMIT);
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
