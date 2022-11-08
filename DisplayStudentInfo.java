package com.quiz;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayStudentInfo implements MainInterface{
				
		
	

		public void getScore() {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your ID : ");
			String id = sc.next();
			
			
			
			 PreparedStatement ps = null;
			 PreparedStatement ps1 = null;
			 Connection connection1 = null;	
			connection1 = ConnectionTest.getConnectionDetails();
			try {
			
				String selectStatement = "select student.id, student.studentname, marks.score, grade.grade from student Inner join marks on student.id = marks.id Inner join grade on student.id = grade.id where student.id ="+id+";";
				ps = connection1.prepareStatement(selectStatement);
			
				ResultSet rs1 = ps.executeQuery();
				ResultSetMetaData rsmd = rs1.getMetaData();
				
				int columnsNumber = rsmd.getColumnCount();
				
				boolean check = false;
				
				
				try {
					while(rs1.next()) {
						
						String columnValue1 = rs1.getString(1);
						
						if(columnValue1.equals(id)) {
							System.out.println(rs1.getString(1));
							System.out.println("*********************");
							System.out.println("*  YOUR SCORE CARD  *");
							System.out.println("*********************");
							System.out.println("ID    :"+ rs1.getInt(1));
							System.out.println("Name  :"+ rs1.getString(2));
							System.out.println("Marks :"+ rs1.getInt(3));
							System.out.println("Grade :"+ rs1.getString(4));
							System.out.println("______________________________");
						 check = true;
						}
					}
					
					if(check == false) {
						throw new InvalidIdException("invalid input");
					}
					
				} catch (InvalidIdException e) {
					System.err.println(e.getMessage());
				}
				
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		public  void displayHighScore() {
			System.out.println("High Score :");
			PreparedStatement ps = null;
			 PreparedStatement ps1 = null;
			 Connection connection1 = null;	
			connection1 = ConnectionTest.getConnectionDetails();
			
			try {
				String selectStatement = "select student.id, student.studentname, marks.score, grade.grade from student Inner join marks on student.id = marks.id Inner join grade on student.id = grade.id order by  marks.score desc ;";
				ps = connection1.prepareStatement(selectStatement);
				
				ResultSet rs1 = ps.executeQuery();
				ResultSetMetaData rsmd = rs1.getMetaData();
				
				int columnsNumber = rsmd.getColumnCount();
				
				
				try {
					while(rs1.next()) {
						
						

						
							
							System.out.println("");
							System.out.println("ID: "+ rs1.getInt(1)+"  |  Name: "+ rs1.getString(2)+"  |  Marks: "+ rs1.getInt(3)+"  |  Grade: "+ rs1.getString(4));
							System.out.println("___________________________________________________________");
							
						 
						
							
						
					}
					
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
}

		@Override
		public void getQuiz() {
			// TODO Auto-generated method stub
			
		}

		

		
}
