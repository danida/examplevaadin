package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
@UIScope
public class UserManagement  extends VerticalLayout{
	@Autowired
	UserRepository userrepository;
	
	@PostConstruct
	public void init(){}
	
	public void save (User user){
		userrepository.save(user);
		
	}
	
}
