package Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.*;

public class Model {

    public TableModel getTableModel() {
        return tableModel;
    }

    private TableModel tableModel;
    private String[] woArr;

    public Model() {
        updateTable(1); //TODO change parameter
        updateList();
    }

    public String[] getWoListModel() {
        return woArr;
    }

    public void updateList() {
        try {
            woArr = WorkoutManager.getAllWoNames();
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

    }

    public void updateTable(int workoutID) {
        if (tableModel == null) {
            tableModel = new TableModel() {
                @Override
                public int getRowCount() {
                    return 0;
                }

                @Override
                public int getColumnCount() {
                    return 0;
                }

                @Override
                public String getColumnName(int columnIndex) {
                    return null;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return null;
                }

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    return null;
                }

                @Override
                public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

                }

                @Override
                public void addTableModelListener(TableModelListener l) {

                }

                @Override
                public void removeTableModelListener(TableModelListener l) {

                }
            };
        }

        try {
            WorkoutManager.getWoExeForId(workoutID);
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

    }


}


