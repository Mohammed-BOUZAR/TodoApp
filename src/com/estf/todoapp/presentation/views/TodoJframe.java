package com.estf.todoapp.presentation.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.estf.todoapp.beans.Todo;

import java.awt.FlowLayout;  
public class TodoJframe extends JFrame{

	private JPanel rootPanel;
	private TodoForm todoForm;
	private TodoList todoList;
	
	public TodoJframe() {
		super("Todo App");
		setSize(1000, 700);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    rootPanel = new JPanel();
	    rootPanel.setLayout(new FlowLayout());
	    
	    todoForm=new TodoForm(this);
	    todoList=new TodoList();
	    
	    rootPanel.add(todoForm);
	    rootPanel.add(todoList);
	    
	    setContentPane(rootPanel);
	    setVisible(true);
	}
	
	public void addNewData(Todo todo) {
		todoList.addNewData(todo);
		revalidate();
		repaint();
	}
}
