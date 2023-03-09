package com.estf.todoapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.estf.todoapp.beans.Todo;

public class TodoDaoJdbc implements TodoDao{
	private ConnectDB condb = new ConnectDB();
	@Override
	public Todo insert(Todo todo) {
		condb.insert(todo);
		return todo;
	}

	@Override
	public Todo update(Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo delete(Todo todo) {
		System.out.println("Todo JDBC: " + todo.getId());
		condb.delete(todo);
		return todo;
	}

	@Override
	public Todo get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Todo> getAll() {
		return condb.getAll();
	}

}
