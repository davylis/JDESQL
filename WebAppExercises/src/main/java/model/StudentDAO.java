package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.google.gson.Gson;
import data_access.ConnectionParameters;
import data_access.DbUtils;
import java.util.ArrayList;


public class StudentDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public StudentDAO() {
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	/**
	 * Open a new database connection
	 */
	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	/**
	 * Close a new database connection
	 */
	private void closeConnection() {
		DbUtils.closeQuietly(resultSet, preparedStatement, connection);
	}

	/**
	 * Retrieve all Students from the database
	 */
	public List<Student> getStudents() {
		List<Student> StudentList = new ArrayList<Student>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetAddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postOffice = resultSet.getString("postoffice");

				StudentList.add(new Student(id, firstname, lastname, streetAddress, postcode, postOffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
			StudentList = null;

		} finally {
			closeConnection();
		}

		return StudentList;
	}

	public String getAllStudentsJSON() {
		List<Student> studentList = getStudents();
		Gson gson = new Gson();
		return gson.toJson(studentList);
	}

	public Student getStudentByID(int studentId) {
		Student student = null;
		try {
			connection = openConnection();
			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetAddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postOffice = resultSet.getString("postoffice");

				student = new Student(id, firstname, lastname, streetAddress, postcode, postOffice);
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudentByID() failed. " + sqle.getMessage() + "\n");
		} finally {
			closeConnection();
		}

		return student;
	}

	public int insertStudent(Student student) {
		int errorCode = 0;
		try {
			connection = openConnection();
			

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstname());
			preparedStatement.setString(3, student.getLastname());
			preparedStatement.setString(4, student.getStreetAddress());
			preparedStatement.setString(5, student.getPostCode());
			preparedStatement.setString(6, student.getPostOffice());

			System.out.println(student);

			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				System.out.println("\n[ERROR] StudentDAO: insertStudent() failed. " + sqle.getMessage() + "\n");
				errorCode = -1;
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}
		return errorCode;
	}

	public int deleteStudent(int studentId) {
		int errorCode = 0;
		try {
			connection = openConnection();
			String sqlText = "DELETE FROM student WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Student deleted!");
			} else {
				System.out.println("Nothing deleted. Unknown student id (" + studentId + ")");
				errorCode = 1;
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
			errorCode = -1;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
		return errorCode;
	}

	public int UpdateStudent(Student student) {
		int errorCode = 0;
		try {
			connection = openConnection();

			String sqlText = "UPDATE Student SET firstname=?, lastname=?, streetaddress=?, postcode=?, postoffice=? WHERE id=?";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setString(1, student.getFirstname());
			preparedStatement.setString(2, student.getLastname());
			preparedStatement.setString(3, student.getStreetAddress());
			preparedStatement.setString(4, student.getPostCode());
			preparedStatement.setString(5, student.getPostOffice());
			preparedStatement.setInt(6, student.getId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected != 1) {
				errorCode = 1;
			} else {
				System.out.println();
				System.out.println("Student data updated!");
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: updateStudent() failed. " + sqle.getMessage() + "\n");
			errorCode = -1;
		} finally {
			closeConnection();
		}
		return errorCode;
	}

}
