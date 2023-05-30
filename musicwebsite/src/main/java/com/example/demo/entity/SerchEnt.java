package com.example.demo.entity;

public class SerchEnt {
	private String user_id;
	private String name;
	private String genre;
	private String comment;
	private String board;
	private java.sql.Timestamp attime;
	
	public SerchEnt() {}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre= genre;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment= comment;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board= board;
	}
	public java.sql.Timestamp getAttime() {
		return attime;
	}

	public void setAttime(java.sql.Timestamp attime) {
		this.attime= attime;
	}

}
