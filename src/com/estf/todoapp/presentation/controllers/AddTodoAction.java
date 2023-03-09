package com.estf.todoapp.presentation.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.estf.todoapp.beans.Todo;
import com.estf.todoapp.business.DefaultServices;
import com.estf.todoapp.presentation.views.TodoForm;
public class AddTodoAction implements ActionListener{

	private TodoForm todoForm;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//recuperation des donnees
		String title = todoForm.getTitle();
		String completed= todoForm.getCompleted();
		//verification des donnees
		if(title.equals("") || completed.equals(""))
		{
			JOptionPane.showMessageDialog(todoForm, "all fields are required");
			return;
		}
		if(!(completed.equals("true") || completed.equals("false")))
		{
			JOptionPane.showMessageDialog(todoForm, "completed must be true or false");
			return;
		}
		// envoi des donnes pour insertion
		Todo todo= new Todo(title,Boolean.parseBoolean(completed));
		if(DefaultServices.getInstance().addTodo(todo)==null)
			JOptionPane.showMessageDialog(todoForm, "error");
		else
		{
			// mise a jour
			todoForm.getTodoJframe().addNewData(todo);
			// vider les champs
			todoForm.vider();
		}
	
		
		
	}

	public void setTodoForm(TodoForm todoForm) {
		this.todoForm=todoForm;
	}
}
