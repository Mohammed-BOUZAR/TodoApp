package com.estf.todoapp.beans;

public class Todo {
	private int id;
	private String title;
	private boolean completed;
	
	
	public Todo() {
		super();
	}
	public Todo(String title, boolean completed) {
		super();
		this.title = title;
		this.completed = completed;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
