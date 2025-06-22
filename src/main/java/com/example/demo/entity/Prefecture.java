package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "m_prefectures")
public class Prefecture {
	
	/**
	 * フィールド
	 */
	@Id
	private String code; // 都道府県コード
	private String name; // 都道府県名
	
}
