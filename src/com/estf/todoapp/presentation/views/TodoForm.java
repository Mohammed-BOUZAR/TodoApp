package com.estf.todoapp.presentation.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.estf.todoapp.presentation.controllers.AddTodoAction;
import com.estf.todoapp.utils.InputBuilder;

public class TodoForm extends JPanel{
	
	private JButton addBtn;
	private JButton resetBtn;
	
	private BoxLayout boxLayout;
	
	private InputBuilder titleInputBuilder;
	private InputBuilder completedInputBuilder;
	
	private TodoJframe todoJframe;
	public TodoForm(TodoJframe todoJframe) {
		this.todoJframe=todoJframe;
		boxLayout= new BoxLayout(this, boxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		titleInputBuilder=new InputBuilder("title");
		completedInputBuilder=new InputBuilder("completed");
		
		add(titleInputBuilder);
		add(completedInputBuilder);
		
		JPanel panelBtns= new JPanel();
		addBtn=new JButton("add");
		resetBtn=new JButton("reset");
		
		//injection de dependence
		AddTodoAction addTodoAction=new AddTodoAction();
		addTodoAction.setTodoForm(this);
		addBtn.addActionListener(addTodoAction);
		
		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vider();
			}

			
		});
		
		panelBtns.add(resetBtn);
		panelBtns.add(addBtn);
		
		add(panelBtns);
	}
	public String getTitle() {
		return titleInputBuilder.getText();
	}
	public String getCompleted() {
		return completedInputBuilder.getText();
	}
	public void vider() {
		titleInputBuilder.vider();
		completedInputBuilder.vider();
	}
	public TodoJframe getTodoJframe() {
		return todoJframe;
	}
	
}
