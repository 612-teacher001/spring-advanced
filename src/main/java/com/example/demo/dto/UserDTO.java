package com.example.demo.dto;

import lombok.Data;

/**
 * 利用者一覧表示用DTO
 */
@Data
public class UserDTO {
	
	/**
	 * フィールド
	 */
	private Integer id;        // 利用者ID
	private String role;       // 権限名
	private String name;       // 利用者氏名
	private String prefecture; // 都道府県名
	private String address;    // 住所
	private String phone;      // 電話番号
	private String email;      // メールアドレス
	private String birthday;   // 生年月日
	private String password;   // パスワード
	
}
