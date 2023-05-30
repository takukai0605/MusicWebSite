package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm2;

@Repository
public class UserDao {
	private final JdbcTemplate db;

	@Autowired
	public UserDao(JdbcTemplate db) {
		this.db = db;
	}
	public void insertDb(EntForm2 entform) {
		db.update("INSERT INTO `users` (name,password) VALUES(?,?)", entform.getName(), entform.getPassword());
	}
	public List<EntForm2> searchDb(){
		String sql = "SELECT * FROM `users`";

		//�f�[�^�x�[�X������o�����f�[�^��resultDB1�ɓ����
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);

		//��ʂɕ\�����₷���`��List(resultDB2)��p��
		List<EntForm2> resultDb2 = new ArrayList<EntForm2>();

		//1�����s�b�N�A�b�v
		for(Map<String,Object> result1:resultDb1) {

			//�f�[�^1������1�̂܂Ƃ܂�Ƃ���EntForm�^�́uentformdb�v�𐶐�
			EntForm2 entformdb = new EntForm2();

			//id�Aname�Apassword�̃f�[�^��entformdb�Ɉڂ�
			entformdb.setId((int)result1.get("id"));
			entformdb.setName((String)result1.get("name"));
			entformdb.setPassword((String)result1.get("password"));

			//�ڂ��ւ����f�[�^��������entformdb���AresultDB2�ɓ����
			resultDb2.add(entformdb);
		}

		//Controller�ɓn��
		return resultDb2;
	}

}
