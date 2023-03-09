package com.estf.todoapp.business;

import java.util.List;

import com.estf.todoapp.beans.Todo;
import com.estf.todoapp.dao.TodoDao;
import com.estf.todoapp.dao.TodoDaoJdbc;
import com.estf.todoapp.dao.TodoDaoMemory;

//Singleton
// 1- private constructor
// 2- instance statique sur la classe elle meme
// 3- mehtode static qui retourne cette instance statique
public class DefaultServices implements Services{

	private static DefaultServices instance = null;
	public static DefaultServices getInstance() {
		if(instance==null)
			instance=new DefaultServices(new TodoDaoJdbc());
		return instance;
	}
	
	private TodoDao todoDao;
	private DefaultServices(TodoDao todoDao) {
		this.todoDao=todoDao;
	}
	@Override
	public Todo addTodo(Todo todo) {
		return todoDao.insert(todo);
	}

	@Override
	public Todo updateTodo(Todo todo) {
		return todoDao.update(todo);
	}

	@Override
	public Todo deleteTodo(Todo todo) {
		System.out.println("Default service: " + todo.getId());
		return todoDao.delete(todo);
	}

	@Override
	public Todo getTodo(int id) {
		return todoDao.get(id);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoDao.getAll();
	}

}
