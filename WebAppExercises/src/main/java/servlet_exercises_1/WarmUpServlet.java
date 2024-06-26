package servlet_exercises_1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/warmup")
public class WarmUpServlet extends HttpServlet {
	// This variable is needed to remove a warning
	private static final long serialVersionUID = 1L;

	// The web server invokes the doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();

		// 2. Write the text to the response (to be sent to the browser)
		out.println("Liisa Davydov");
	}
}