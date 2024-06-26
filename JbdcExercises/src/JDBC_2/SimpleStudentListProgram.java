package JDBC_2;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentListProgram {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		System.out.println("=== Print students ===");

		try {
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);
			String sqlText = "SELECT * FROM Student ORDER BY lastname";
			preparedStatement = connection.prepareStatement(sqlText);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetadress = resultSet.getString("streetaddress");
				int postcode = resultSet.getInt("postcode");
				String postoffice = resultSet.getString("postoffice");

				System.out.println(
						id + ": " + firstname + " " + lastname + ", " + streetadress + ", " + postcode + postoffice);
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
	}
}
// End