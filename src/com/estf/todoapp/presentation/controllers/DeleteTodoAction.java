package com.estf.todoapp.presentation.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.estf.todoapp.business.DefaultServices;
import com.estf.todoapp.presentation.views.TodoItemPanel;
public class DeleteTodoAction implements ActionListener{

	private TodoItemPanel todoItemPanel;
	public DeleteTodoAction(TodoItemPanel todoItemPanel) {
		this.todoItemPanel=todoItemPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("performing delete");
		if(DefaultServices.getInstance().deleteTodo(todoItemPanel.getTodo())!=null)
				todoItemPanel.deleteItem();
	}

}
