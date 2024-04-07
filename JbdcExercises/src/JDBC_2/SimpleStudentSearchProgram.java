package JDBC_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentSearchProgram {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner input = new Scanner(System.in);

		System.out.println("=== Find student by id ===");
		System.out.print("Enter student id: ");
		int numId = Integer.parseInt(input.nextLine());

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "SELECT * FROM student WHERE id = ? ORDER BY firstname";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, numId);
			resultSet = preparedStatement.executeQuery();

			boolean rowFound = false;
			while (resultSet.next()) {
				rowFound = true;

				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetadress = resultSet.getString("streetaddress");
				int postcode = resultSet.getInt("postcode");
				String postoffice = resultSet.getString("postoffice");

				System.out.println(
						id + ", " + firstname + " " + lastname + ", " + streetadress + ", " + postcode + postoffice);
			}
			if (rowFound == false) {
				System.out.println("Unknown student id (" + numId + ")");
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
		input.close();
	}
}
