package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.user.EntForm1;

public class UserDao1 {
	
	private final JdbcTemplate db;
	public UserDao1(JdbcTemplate db) {
		this.db = db;
	}
	public void insertDb(EntForm1 entform) {
		db.update("INSERT INTO users (name,password) VALUES(?,?)", entform.getName(), entform.getPassword());
	}

}
