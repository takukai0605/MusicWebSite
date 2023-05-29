package com.example.demo.entity;

public class InputSearch {
	private String user_id="matuki0401";
	private String name="まっちゃん";
	private String genre="バラード";
	private String comment;
	
	public InputSearch() {}

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

}
