package com.estf.todoapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.estf.todoapp.beans.Todo;

public class ConnectDB {
	private String url;
	private String username;
	private String password;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private int lastId;

	public ConnectDB() {
		lastId = 1;
		try {
			url = "jdbc:mysql://localhost:3306/Java";
			username = "root";
			password = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Todo insert(Todo todo) {
		String sql = "INSERT INTO todo (id, title, completed) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			todo.setId(lastId);
			stmt.setInt(1, todo.getId());
			stmt.setString(2, todo.getTitle());
			stmt.setString(3, String.valueOf(todo.isCompleted()));
			if (stmt.executeUpdate() != 0) {
				JOptionPane.showMessageDialog(null, todo.getId() + " Added with Successfuly!");
				System.out.println("inserted: " + todo.getId() + " | " + todo.getTitle() + " | " + todo.isCompleted());
				lastId++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todo;
	}

	public void delete(Todo todo) {
		System.out.println("ConnDB: " + todo.getId());
		String sql = "DELETE FROM todo WHERE id = " + todo.getId() + "";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			if (stmt.executeUpdate() != 0)
				JOptionPane.showMessageDialog(null, todo.getId() + " Deleted with Successfuly!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Todo> getAll() {
		List<Todo> todos = new ArrayList<>();
		String sql = "SELECT * FROM todo;";
		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String completed = resultSet.getString("completed");
				Todo todo = new Todo();
				todo.setId(id);
				todo.setTitle(title);
				todo.setCompleted(completed.equals("true") ? true : false);
				todos.add(todo);
				lastId = id+1;
				System.out.println(todo.getId() + " | " + todo.getTitle() + " | " + todo.isCompleted());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}
}
