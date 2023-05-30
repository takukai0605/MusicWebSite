package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SerchEnt;

@Repository
public class SerchDao {
	private final JdbcTemplate db;
	
	@Autowired
	public SerchDao(JdbcTemplate db) {
		this.db = db;
	}
	
	public void insertDb(SerchEnt entform) {
		db.update("INSERT INTO form (name,comment,attime) VALUES(?,?)", entform.getName(), entform.getComment(), entform.getAttime());
	}
	
	public List<SerchEnt> searchDb(){
		String sql = "SELECT * FROM form";
		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		//画面に表示しやすい形のList(resultDB2)を用意
		List<SerchEnt> resultDb2 = new ArrayList<SerchEnt>();
		//1件ずつピックアップ
		for(Map<String,Object> result1:resultDb1) {
		//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
		SerchEnt entformdb = new SerchEnt();
		//id、nameのデータをentformdbに移す
		entformdb.setUser_id((String)result1.get("user_id"));
		entformdb.setBoard((String)result1.get("board"));
		entformdb.setName((String)result1.get("name"));
		entformdb.setGenre((String)result1.get("genre"));
		entformdb.setComment((String)result1.get("comment"));
		entformdb.setAttime((java.sql.Timestamp)result1.get("attime"));
		//移し替えたデータを持ったentformdbを、resultDB2に入れる
		resultDb2.add(entformdb);
		}
		//Controllerに渡す
		return resultDb2;
		}
	
}
