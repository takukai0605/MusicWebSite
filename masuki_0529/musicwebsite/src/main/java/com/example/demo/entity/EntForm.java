package com.example.demo.entity;

public class EntForm {
	private int id;
	private String name;
	private String password;
	private String genre;
	private String comment;
	private java.sql.Timestamp attime;
	
	public EntForm() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public 	java.sql.Timestamp getAttime() {
		return attime;
	}

	public void setAttime(java.sql.Timestamp attime) {
		this.attime = attime;
	}
	
	
}

