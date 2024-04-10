package JdbcExercises_5;

import java.util.Scanner;
import JdbcExercises_3_Davydov.StudentDAO;
import model.Student;

public class StudentUpdateProgram {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		Scanner input = new Scanner(System.in);
		
		System.out.print("=== Update student === \n");
		
		System.out.print("Id: ");
		int id = Integer.parseInt(input.nextLine());

		System.out.print("First name: ");
		String firstname = input.nextLine();

		System.out.print("Last name: ");
		String lastname = input.nextLine();

		System.out.print("Street: ");
		String street = input.nextLine();

		System.out.print("Postcode: ");
		String postcode = input.nextLine();

		System.out.print("Post office: ");
		String office = input.nextLine();
		
		Student student = new Student(id, firstname, lastname, street, postcode, office);
		
		int result = studentDAO.UpdateStudent(student);
		if(result!=0) {
			System.out.println("Error occured, exiting with code " + result);
			System.exit(result);
		}
		
		input.close();
	}

}

