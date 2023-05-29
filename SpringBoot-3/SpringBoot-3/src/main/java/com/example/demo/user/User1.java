package com.example.demo.user;

public class User1 {
	

	private Long id; // ��L�[�Ƃ��Ďg�p����t�B�[���h��ǉ�

	private String name;
	private String password;

	public User1() {
	}

	public User1(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// getter and setter methods
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


}
