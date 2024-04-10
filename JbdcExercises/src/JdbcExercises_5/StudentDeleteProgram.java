package JdbcExercises_5;

import java.util.Scanner;

import JdbcExercises_3_Davydov.StudentDAO;

public class StudentDeleteProgram {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		Scanner input = new Scanner(System.in);
		
		System.out.println("=== Delete student ===");
		System.out.print("Enter student id: ");
		int numId = Integer.parseInt(input.nextLine());
		
		int result = studentDAO.deleteStudent(numId);
		if(result!=0) {
			System.out.println("Error occured, exiting with code " + result);
			System.exit(result);
		}
		
		input.close();
	}

}
