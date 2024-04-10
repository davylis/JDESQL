package servlet_exercises_1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Student;

@WebServlet("/jsonStudents")
public class JsonStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s1 = new Student(1, "vasi", "pusik", "Ratapihantie 13", "00520", "HELSINKI");
		Student s2 = new Student(2, "lisa", "pusik", "Ratapihantie 13", "00520", "HELSINKI");
		Student s3 = new Student(3, "luka", "pusik", "Ratapihantie 13", "00520", "HELSINKI");
		ArrayList <Student> students = new ArrayList <Student>();
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		Gson gson = new Gson();
		String json = gson.toJson(students); // (1)

		//output as a JSON, not a text
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

}
