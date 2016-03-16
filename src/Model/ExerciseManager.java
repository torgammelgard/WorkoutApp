package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseManager {

    public static List<ExercisesBean> getAllExercises() throws SQLException {
        List<ExercisesBean> beans = new ArrayList<>(10);

        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM exercises")

        ) {
            while (rs.next()) {
                ExercisesBean bean = new ExercisesBean();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setDescription(rs.getString("description"));
                beans.add(bean);
            }

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

        return beans;
    }
    public static String[] getExerciseNamesForWorkout(int workoutID) {
        String[] names = new String[0];
        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT name FROM exercises e JOIN workouts_exercises we ON e.id = we.exercise_id WHERE we.workout_id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            stmt.setInt(1, workoutID);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            names = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
               names[i++] = rs.getString("name");
            }

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

        return names;
    }

	public static boolean insertExercise(ExercisesBean bean) throws SQLException {

		 try (
	                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
				 	PreparedStatement stmt = conn.prepareStatement("INSERT INTO exercises (name, description) VALUES (?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	                

	        ) {
			 	stmt.setString(1, bean.getName());
	            stmt.setString(2, bean.getDescription());
			 	int affectedRows = stmt.executeUpdate();
	            System.out.println("Affected rows : " + affectedRows);
			 	return affectedRows == 1;
			 	
	        } catch (SQLException e) {
	            System.err.println("Error message: " + e.getMessage());
	            System.err.println("Error code: " + e.getErrorCode());
	            System.err.println("SQL state: " + e.getSQLState());
	        }

		
		return false;
	}
}
