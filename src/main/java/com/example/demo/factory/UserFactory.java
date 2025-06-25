package com.example.demo.factory;

import java.time.LocalDate;

import com.example.demo.entity.Prefecture;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public class UserFactory {

	/**
	 * 利用者クラスのフィールドを本に一括してインスタンスを生成する
	 * @param id             利用者ID
	 * @param roleId         権限コード
	 * @param name           利用者氏名
	 * @param prefectureCode 都道府県コード
	 * @param address        住所
	 * @param phone          電話番号
	 * @param email          電子メール
	 * @param birthday       生年月日
	 * @param password       パスワード
	 * @return
	 */
	public static User create(Integer id, Integer roleId, String name, String prefectureCode, String address, String phone, String email, String birthday, String password) {
		// 権限コードを下に権限インスタンスを生成
		Role role = new Role();
		role.setId(roleId);
		// 都道府県コードから都道府県インスタンスを生成
		Prefecture prefecture = new Prefecture();
		prefecture.setCode(prefectureCode);
		
		// 利用者のインスタンスを生成
		User user = new User();
		user.setId(id);
		user.setRole(role);
		user.setName(name);
		user.setPrefecture(prefecture);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setBirthday(LocalDate.parse(birthday));
		user.setPassword(password);
		
		// 生成した利用者インスタンスを返却
		return user;
	}
	
}
