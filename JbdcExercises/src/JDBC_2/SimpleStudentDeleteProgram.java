package JDBC_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentDeleteProgram {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner input = new Scanner(System.in);

		System.out.println("=== Delete student ===");
		System.out.print("Enter student id: ");
		int numId = Integer.parseInt(input.nextLine());

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "DELETE FROM student WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, numId);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Student deleted!");
			} else {
				System.out.println("Nothing deleted. Unknown student id (" + numId + ")");
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
		input.close();
	}
}