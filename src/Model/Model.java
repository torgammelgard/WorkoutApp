package Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.List;

public class Model {

    public TableModel getTableModel() {
        return tableModel;
    }

    private TableModel tableModel;
    private List<WorkoutsBean> workouts;
    private String[] columnNames = new String[]{"Name", "Sets", "Reps", "Weight"};

    public Model() {
        initTable();
        updateList();
    }

    public String[] getWoListModel() {
        String[] names = new String[workouts.size()];
        int i = 0;
        for (WorkoutsBean workout : workouts) {
            names[i++] = workout.getName();
        }
        return names;
    }

    public void updateList() {
        try {
            workouts = WorkoutManager.getAllWoNames();
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

    }

    private void initTable() {
        if (tableModel == null) {
            tableModel = new TableModel() {
                @Override
                public int getRowCount() {
                    return 0;
                }

                @Override
                public int getColumnCount() {
                    return columnNames.length;
                }

                @Override
                public String getColumnName(int columnIndex) {
                    return columnNames[columnIndex];
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return String.class;
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
    }
    public void updateTable(int selectionIndex) {

        try {
            int id = 0;
            if (workouts != null) {
                id = workouts.get(selectionIndex).getId();
            }

            List<WorkoutsExercisesBean> workoutsExercisesBeans = WorkoutManager.getWorkoutsExercises(id);
            tableModel = new TableModel() {
                @Override
                public int getRowCount() {
                    return workoutsExercisesBeans.size();
                }

                @Override
                public int getColumnCount() {
                    return columnNames.length;
                }

                @Override
                public String getColumnName(int columnIndex) {
                    return columnNames[columnIndex];
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return String.class;
                }

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    WorkoutsExercisesBean bean = workoutsExercisesBeans.get(rowIndex);
                    switch (columnIndex) {
                        case 0: return bean.getEx_id();
                        case 1: return bean.getSets();
                        case 2: return bean.getReps();
                        case 3: return bean.getWeight();
                        default: return null;
                    }
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
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

    }

    public boolean insertWorkout(WorkoutsBean bean) {
        try {
            if (WorkoutManager.insertWorkout(bean)) {
                updateList();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


