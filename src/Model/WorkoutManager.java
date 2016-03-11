package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class WorkoutManager {

	private static final String USERNAME = "sql_project2";
	private static final String PASSWORD = "sql_project";
	private static final String CONN_STRING = "jdbc:mysql://localhost/sql_project";

	public static void getAllRows() throws SQLException {
		try(
				Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT name FROM workouts");
				
				){
			while(rs.next())
				System.out.println(rs.getString(1));
		} catch (SQLException e) {
			System.err.println("Error message: " + e.getMessage());
			System.err.println("Error code: " + e.getErrorCode());
			System.err.println("SQL state: " + e.getSQLState());
		}
	}
}
