package servlet_exercises_2;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Student;
import model.StudentDAO;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<Student> students = dao.getStudents();
		
		Gson gson = new Gson();
		String json = gson.toJson(students); // (1)

		//output as a JSON, not a text
		response.getWriter().print(json);
	}
}
