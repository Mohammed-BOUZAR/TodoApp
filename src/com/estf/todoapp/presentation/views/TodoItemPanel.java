package com.estf.todoapp.presentation.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.estf.todoapp.beans.Todo;
import com.estf.todoapp.business.DefaultServices;
import com.estf.todoapp.presentation.controllers.DeleteTodoAction;

public class TodoItemPanel extends JPanel{
	private Todo todo;
	private JLabel titleLabel;
	private JLabel completedLabel;
	private JButton deleteBtn;
	
	private TodoList todoList;
	
	public TodoItemPanel(Todo todo,TodoList todoList) {
		this.todoList=todoList;
		this.todo=todo;
		setLayout(new FlowLayout());
		titleLabel=new JLabel(this.todo.getTitle());
		completedLabel=new JLabel(this.todo.isCompleted()+"");
		deleteBtn=new JButton("Delete");
		add(titleLabel);
		add(completedLabel);
		add(deleteBtn);
		DeleteTodoAction deleteTodoAction=new DeleteTodoAction(this);
		deleteBtn.addActionListener(deleteTodoAction);
		
	}
	public void deleteItem() {
		todoList.remove(this);
		todoList.revalidate();
		todoList.repaint();

	}
	public Todo getTodo() {
		return todo;
	}
	

}
