package com.estf.todoapp.presentation;

import com.estf.todoapp.business.DefaultServices;
import com.estf.todoapp.dao.TodoDaoMemory;
import com.estf.todoapp.presentation.views.TodoJframe;

public class Main {

	public Main() {
		
		new TodoJframe();
	}
	public static void main(String[] args) {
		new Main();

	}

}
