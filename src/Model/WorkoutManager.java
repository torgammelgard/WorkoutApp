package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutManager {

    public static List<WorkoutsBean> getAllWorkouts() throws SQLException {
        List<WorkoutsBean> beans = new ArrayList<>(10);

        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM workouts")

        ) {
            while (rs.next()) {
                WorkoutsBean bean = new WorkoutsBean();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setType(rs.getString("type"));
                bean.setInfo(rs.getString("info"));
                bean.setDate(rs.getDate("date"));
                beans.add(bean);
            }

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

        return beans;
    }

    public static List<WorkoutsBean> searchWorkouts(String searchString) throws SQLException {
        List<WorkoutsBean> beans = new ArrayList<>(10);

        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM workouts WHERE name LIKE ? OR type LIKE ? OR info LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            stmt.setString(1, "%" + searchString + "%");
            stmt.setString(2, "%" + searchString + "%");
            stmt.setString(3, "%" + searchString + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                WorkoutsBean bean = new WorkoutsBean();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setType(rs.getString("type"));
                bean.setInfo(rs.getString("info"));
                bean.setDate(rs.getDate("date"));
                beans.add(bean);
            }

        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

        return beans;
    }

    public static boolean insertWorkout(WorkoutsBean bean) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(DatabaseSettings.CONN_STRING, DatabaseSettings.USERNAME, DatabaseSettings.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO workouts (name, type, info, date) VALUES (?, ?, ?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            stmt.setString(1, bean.getName());
            stmt.setString(2, bean.getType());
            stmt.setString(3, bean.getInfo());
            stmt.setDate(4, bean.getDate());
            int affectedRows = stmt.executeUpdate();
            return (affectedRows == 1);
        }
    }
}
