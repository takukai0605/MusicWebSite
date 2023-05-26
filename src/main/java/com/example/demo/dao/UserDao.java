package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class UserDao {
	private final JdbcTemplate db;

	@Autowired
	public UserDao(JdbcTemplate db) {
		this.db = db;
	}
	public void insertDb(EntForm entform) {
		db.update("INSERT INTO users (name,password) VALUES(?,?)", entform.getName(), entform.getPassword());
	}

}
