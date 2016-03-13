package Model;

import java.sql.*;

public class WorkoutManager {

    private static final String USERNAME = "sql_project2";
    private static final String PASSWORD = "sql_project";
    private static final String CONN_STRING = "jdbc:mysql://localhost:8889/sql_project";

    public static String[] getAllWoNames() throws SQLException {
        String[] resArray = null;

        try (
                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT name FROM workouts")

        ) {
            rs.last();
            int num_rows = rs.getRow();
            rs.beforeFirst();
            resArray = new String[num_rows];
            int i = 0;
            while (rs.next())
                resArray[i++] = rs.getString("name");

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

        return resArray != null ? resArray : new String[0];
    }

    // TODO create a workoutsExercisesBean for this method to return
    public static void getWoExeForId(int woID) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT sets, reps, weight FROM workouts_exercises WHERE workout_id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            stmt.setInt(1, woID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("sets"));
            }
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }
    }
}
