package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ent;

@Repository
public class FormDao {
	private final JdbcTemplate db;
	@Autowired
	public FormDao(JdbcTemplate db) {
		this.db = db;
	}
	public void insertDb(Ent entform) {
		db.update("INSERT INTO form (id,name,password,comment) VALUES(?,?,?,?)",entform.getName(),entform.getComment() );
	}

}
