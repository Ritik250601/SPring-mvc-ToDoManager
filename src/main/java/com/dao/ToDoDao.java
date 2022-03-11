package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entities.Todo;


public class ToDoDao {
	public boolean saveTodo(Todo todo) {
		boolean f = false;
		try {
			// Get the Connnection
			Connection con = ConnectionProvider.createC();
			String query = "INSERT INTO todo(todoTitle, todoContent) VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, todo.getTodoTitle());
			pstmt.setString(2, todo.getTodoContent());
			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
	public List<Todo> getTodo(){
		List<Todo> list = new ArrayList<Todo>();
		
		try {
			Connection con = ConnectionProvider.createC();
			String query = "SELECT * FROM todo";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Todo todo = new Todo(rs.getString(2), rs.getString(3));
				list.add(todo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	
}

