package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class FormDao {
	private final JdbcTemplate db;

	@Autowired
	public FormDao(JdbcTemplate db) {
		this.db = db;
	}
	
	
	
	
	
	public void insertDb(EntForm entform) {
		db.update("INSERT INTO form (genre,name,comment,attime) VALUES(?,?,?,?)", entform.getGenre(), entform.getName(),entform.getComment(),entform.getAttime());
	}
	
	//データベース処理
	public List<EntForm> searchDb() {
		String sql = "SELECT * FROM form";

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		for (Map<String, Object> result1 : resultDb1) {
			EntForm entformdb = new EntForm();
			entformdb.setGenre((String) result1.get("genre"));
			entformdb.setName((String) result1.get("name"));
			entformdb.setComment((String) result1.get("comment"));
			entformdb.setAttime((java.sql.Timestamp)result1.get("attime"));  
			resultDb2.add(entformdb);
		}

		return resultDb2;

	}
	
	
	public List<EntForm> genre1Db() {
		String sql = "SELECT * FROM form WHERE genre='J-POP'";

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		for (Map<String, Object> result1 : resultDb1) {
			EntForm entformdb = new EntForm();
			entformdb.setName((String) result1.get("name"));
			entformdb.setComment((String) result1.get("comment"));
			entformdb.setAttime((java.sql.Timestamp) result1.get("attime"));
			resultDb2.add(entformdb);
		}

		return resultDb2;

	}
	
	public List<EntForm> genre2Db() {
		String sql = "SELECT * FROM form WHERE genre='K-POP'";

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		for (Map<String, Object> result1 : resultDb1) {
			EntForm entformdb = new EntForm();
			entformdb.setName((String) result1.get("name"));
			entformdb.setComment((String) result1.get("comment"));
			entformdb.setAttime((java.sql.Timestamp) result1.get("attime"));
			resultDb2.add(entformdb);
		}

		return resultDb2;

	}
	
	public List<EntForm> genre3Db() {
		String sql = "SELECT * FROM form WHERE genre='バラード'";

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		for (Map<String, Object> result1 : resultDb1) {
			EntForm entformdb = new EntForm();
			entformdb.setName((String) result1.get("name"));
			entformdb.setComment((String) result1.get("comment"));
			entformdb.setAttime((java.sql.Timestamp) result1.get("attime"));
			resultDb2.add(entformdb);
		}

		return resultDb2;

	}
	


}
