package FullStackExercises_2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Student;
import model.StudentDAO;

@WebServlet("/addStudent")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.getWriter().print("You must enter id as an integer");
			response.setStatus(400);
			return;
		}
		StudentDAO dao = new StudentDAO();

		int num = dao.deleteStudent(id);
		String result = "\"errorcode\" : " + num;
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.getWriter().print("You must enter id as an integer");
			response.setStatus(400);
			return;
		}
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String streetAddress = request.getParameter("streetaddress");
		String postCode = request.getParameter("postcode");
		String postOffice = request.getParameter("postoffice");

		StudentDAO dao = new StudentDAO();

		Student person = new Student(id, firstname, lastname, streetAddress, postCode, postOffice);
		int num = dao.insertStudent(person);
		String result = "{\"errorcode\": " + num + "}";
		response.setContentType("application/json");
		response.getWriter().print(result);
	}
}
