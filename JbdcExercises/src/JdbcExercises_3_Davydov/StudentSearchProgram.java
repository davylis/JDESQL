package JdbcExercises_3_Davydov;

import java.util.List;
import java.util.Scanner;

//import data_access.MovieDAO;
import model.Student;

public class StudentSearchProgram {

	public static void main(String[] args) {
		System.out.println("=== Find student by id (DAO version) ===");
		StudentDAO studentDAO = new StudentDAO();
		Scanner input = new Scanner(System.in);
		List<Student> studentList = studentDAO.getStudents();
		
		System.out.print("Enter student id: ");
		int id = input.nextInt();
		boolean find = false;
		
		if (studentList == null) {
			System.out.println("The database is temporarily unavailable. Please try again later.");
		} else {
			for (Student student : studentList) {
				if(student.getId()==id) {
				System.out.println(student.getId() + ", " + student.getFirstname() + " " + student.getLastname() + ", " + student.getStreetAddress() + ", " + student.getPostCode() + " " + student.getPostOffice());
				find = true;
				}
				
			}
			if(!find) {
				System.out.println("Unknown student id (" + id + ")");
			}
			input.close();
		}
	}
}
// End