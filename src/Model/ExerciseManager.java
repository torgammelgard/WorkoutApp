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
}
