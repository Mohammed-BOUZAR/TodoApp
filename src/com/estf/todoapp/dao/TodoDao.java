package com.estf.todoapp.dao;

import java.util.List;

import com.estf.todoapp.beans.Todo;

public interface TodoDao {
	public Todo insert(Todo todo);
	public Todo update(Todo todo);
	public Todo delete(Todo todo);
	public Todo get(int id);
	public List<Todo> getAll();

}
