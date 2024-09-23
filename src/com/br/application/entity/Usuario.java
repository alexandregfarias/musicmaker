package com.br.application.entity;

public class Usuario {
	
	private Long id;
	private String name;
	private String password;
	
	public Usuario() {}

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

	public Long getId() {
		return id;
	}
	
}