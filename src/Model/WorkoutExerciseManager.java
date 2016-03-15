package Model;

import java.sql.*;

public class WorkoutExerciseManager {

    public static boolean deleteWorkoutExercise(int workoutID, int exerciseID) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM workouts_exercises WHERE workout_id = ? AND exercise_id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            stmt.setInt(1, workoutID);
            stmt.setInt(2, exerciseID);
            int result = stmt.executeUpdate();
            return (result > 0);

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }
        return false;
    }

    public static boolean updateWorkoutExercise(WorkoutsExercisesBean bean) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("UPDATE workouts_exercises SET sets = ?, reps = ?, weight = ? WHERE workout_id = ? AND exercise_id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            stmt.setInt(1, bean.getSets());
            stmt.setInt(2, bean.getReps());
            stmt.setInt(3, bean.getWeight());
            stmt.setInt(4, bean.getWo_id());
            stmt.setInt(5, bean.getEx_id());
            int result = stmt.executeUpdate();
            return (result > 0);

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }
        return false;
    }

    public static boolean insertWorkoutExercise(WorkoutsExercisesBean bean) {
        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO workouts_exercises VALUES (?, ?, ?, ?, ?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            stmt.setInt(1, bean.getWo_id());
            stmt.setInt(2, bean.getEx_id());
            stmt.setInt(3, bean.getSets());
            stmt.setInt(4, bean.getReps());
            stmt.setInt(5, bean.getWeight());
            int result = stmt.executeUpdate();
            return (result > 0);

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }
        return false;
    }
}
