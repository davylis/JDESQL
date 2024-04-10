package servlet_exercises_1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String op = request.getParameter("operation");
		String result = "";
		if(op.equalsIgnoreCase("substract")) {
			result = Integer.toString(x)+" - "+Integer.toString(y)+" = "+Integer.toString(x-y);
		}else if(op.equalsIgnoreCase("multiply")) {
			result = Integer.toString(x)+" * "+Integer.toString(y)+" = "+Integer.toString(x*y);
		}else {
			result= "Unsupported operation: " + op;
		}
		response.getWriter().print(result);
	}

}
