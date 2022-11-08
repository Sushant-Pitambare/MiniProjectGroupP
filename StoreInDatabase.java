package com.quiz;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreInDatabase implements MainInterface {
			
	
	
	static PreparedStatement ps = null;
	static Connection connection1 = null;
	
	
	public void storeMarks(int marks) {
		
		connection1 = ConnectionTest.getConnectionDetails();
		try {
			ps = connection1.prepareStatement("insert into marks(score) values(?)");
		
			ps.setInt(1, marks);
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void storeUserName(String name) {
		
		try {
			connection1 = ConnectionTest.getConnectionDetails();
			
			ps = connection1.prepareStatement("insert into student(studentname) values(?)");
			
			ps.setString(1, name);
			
			ps.execute();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}


	@Override
	public void getQuiz() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getScore() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void displayHighScore() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
