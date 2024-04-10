package JdbcExercises_3_Davydov;

public class StudentJSONProgram {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		String json = studentDAO.getAllStudentsJSON();
		System.out.println(json);

	}

}
