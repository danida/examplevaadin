package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	
	public User() {
		super();
	}
	public User(String name) {
		this.id=1;
		this.name = name;
	}
	@Id
	private int id;
	private String name;
}
