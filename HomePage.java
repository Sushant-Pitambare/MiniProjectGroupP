package com.quiz;

import java.util.Scanner;

public class HomePage   {
	
	

	public static void main(String[] args) {
		Display display = new Display();
		DisplayStudentInfo displayStudentInfo  = new DisplayStudentInfo();
		
		Scanner sc = new Scanner(System.in);
		char repeat ;
		
		
			do {
				System.out.println("Welcome!"+ " What do you want to do? ");
				System.out.println("1. Attend Quiz");
				System.out.println("2. Get Score");
				System.out.println("3. Get high Score");
				System.out.println("Enter the choice (1/2/3)");
				int choice = sc.nextInt();
				
				
				
				
				
				switch(choice){
						case 1 : display.getQuiz();
							break;
						case 2: displayStudentInfo.getScore();
							break;
						case 3: displayStudentInfo.displayHighScore();
						
						default : System.out.println("invalid choice!");
						
				}
				
				System.out.println("Do you want to continue? (y/n)");
				repeat = sc.next().charAt(0);
				if(repeat != 'y') {
					System.out.println("Thank you!");
				}
			}while(repeat == 'y');
			
		
		
		
	}

}
