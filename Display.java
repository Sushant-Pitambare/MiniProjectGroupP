package com.quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


// get user answers
//get marks

public class Display implements MainInterface {
	
	StoreInDatabase sib = new StoreInDatabase();
	
	
	public void getQuiz() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name : ");
		String name = sc.nextLine();
		sib.storeUserName(name);
		
		
		int marks=0;
		int counter = 1;
		char userAnswer;
		
		
		try {
			Connection connection = ConnectionTest.getConnectionDetails();
			PreparedStatement ps =  connection.prepareStatement("select *  from qna ORDER BY RAND()");
			ResultSet rs = ps.executeQuery();
			
			//display question and options
			
				while(rs.next()) {
					boolean repeatQuestion = false;
					boolean dontRepeatQuestion = false;
					
					do {
						
					System.out.println(counter + ". "+rs.getString(2));
					System.out.println(" A" + ". "+rs.getString(4));
					System.out.println(" B" + ". "+rs.getString(5));
					System.out.println(" C" + ". "+rs.getString(6));
					System.out.println(" D" + ". "+rs.getString(7));
					System.out.print("Answer : ");
					
					userAnswer = sc.next().charAt(0);
					
					
						char answer = rs.getString(3).charAt(0); //original answer
						
						try {
							if(userAnswer == 'a' || userAnswer == 'b' || userAnswer == 'c' || userAnswer == 'd' || userAnswer == 'A' || userAnswer == 'B' || userAnswer == 'C' || userAnswer==  'D') {
								
								dontRepeatQuestion = true;
								if(userAnswer == answer) {
									marks= marks+1;
									
								}
									
								
							}else {
								
								repeatQuestion = true;
								
								throw new InvalidIdException("invalid input");
								
								
							}
						}catch(InvalidIdException e) {
							System.err.println(e.getMessage());
							
						}
						
					}while(repeatQuestion==true &&  dontRepeatQuestion != true );
				
					//comparing user answer and original answer
				
					System.out.println();
					counter++; 
				}
				
				
				sib.storeMarks(marks);
				
				String grade = "";
				
				//grade
				if(marks<5) {
					grade = "D";
				}else if(marks >=5 && marks<6) {
					grade =  "C";
				}else if(marks >=6 && marks <8 ) {
					grade =  "B";
				}else
					grade = "A";
				
				System.out.println("Your score is :" + marks);
				System.out.println("Your Grade is :" + grade);
				
				//store grade logic 
				
				
					try {
						
						Connection connection1 = ConnectionTest.getConnectionDetails();
						PreparedStatement ps1 = connection1.prepareStatement("insert into grade(grade) values(?) ");
						ps1.setString(1, grade);
						ps1.execute();
					
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				
				
				
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
			
		
		
	
		
		
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
