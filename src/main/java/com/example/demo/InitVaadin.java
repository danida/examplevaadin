package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.*;

@SpringUI
@Theme("valo")
public class InitVaadin extends UI {
	 private VerticalLayout layout;
	 
	 @Autowired
	 UserManagement usermanager;
	
	@Override
	protected void init(VaadinRequest request) {
		setupLayout();
		addHeader();
		addForm();
		addUserManagement();
		addActionButtons();
		
		
	}
		private void setupLayout() {
	        layout = new VerticalLayout();

        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
	        setContent(layout);
	    }

	    private void addHeader() {
	        Label header = new Label("TODO");
	       header.addStyleName(ValoTheme.LABEL_H1);
	        layout.addComponent(header);

	    }

	    private void addForm() {
	        HorizontalLayout formLayout = new HorizontalLayout();
	        formLayout.setWidth("80%");

	        TextField taskField = new TextField();
	        taskField.focus();
	        Button addButton = new Button("Add");

	        formLayout.addComponentsAndExpand(taskField);
	        formLayout.addComponent(addButton);
	        layout.addComponent(formLayout);
	        
	        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
	        addButton.setIcon(VaadinIcons.PLUS);

	        addButton.addClickListener(click -> {
	        	usermanager.save(new User(taskField.getValue()));
	            taskField.setValue("");
	            taskField.focus();
	        });
	        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
	    }

	    private void addUserManagement() {
	       layout.addComponent(usermanager);
	    }

	    private void addActionButtons() {
	        Button deleteButton = new Button("Delete completed items");
	        layout.addComponent(deleteButton);

	}
		
		
		
		
	}


