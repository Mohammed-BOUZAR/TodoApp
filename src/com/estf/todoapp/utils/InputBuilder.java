package com.estf.todoapp.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
public class InputBuilder extends JPanel{

	private String name;
	
	private JLabel label;
	private JTextField textField;
	
	public InputBuilder(String name) {
		this.name=name;
		this.setLayout(new FlowLayout());
		
		label=new JLabel(name);
		textField= new JTextField(20);
		
		add(label);
		add(textField);
		
		
	}
	
	public void setText(String value) {
		textField.setText(value);
	}
	public String getText() {
		return textField.getText();
	}
	public void vider() {
		textField.setText("");
	}
	
}
