package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * usersテーブルの1レコードを管理するクラス
 */
@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "role")
	private Role role;
	private String name;
	@ManyToOne
	@JoinColumn(name = "prefecture")
	private Prefecture prefecture;
	private String address;
	private String phone;
	private String email;
	private LocalDate birthday;
	private String password;
}
