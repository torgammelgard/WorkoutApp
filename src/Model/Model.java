package Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {

    public TableModel getTableModel() {
        return tableModel;
    }

    private int currentWOListSelection = -1;

    private TableModel tableModel;
    private List<WorkoutsBean> workouts;
    private List<WorkoutsExercisesBean> workoutsExercisesBeans;

    private String[] columnNames = new String[]{"Exercise", "Sets", "Reps", "Weight"};

    public Model() {
        initTable();
        updateList();
    }

    public int getWorkoutIDForSelection(int selection) {
        return workouts.get(selection).getId();
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
            workouts = WorkoutManager.getAllWorkouts();
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }

    }

    public void updateSearchList(String searchString) {
        try {
            workouts = WorkoutManager.searchWorkouts(searchString);
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
        currentWOListSelection = selectionIndex;
        try {
            int workoutID = 0;
            if (workouts != null) {
                workoutID = workouts.get(selectionIndex).getId();
            }

            workoutsExercisesBeans = WorkoutExerciseManager.getWorkoutsExercises(workoutID);
            String[] exercise_names = ExerciseManager.getExerciseNamesForWorkout(workoutID);
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
                    if (columnIndex > 0)
                        return true;
                    else
                        return false;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    WorkoutsExercisesBean bean = workoutsExercisesBeans.get(rowIndex);
                    switch (columnIndex) {
                        case 0: return exercise_names[rowIndex];
                        case 1: return bean.getSets();
                        case 2: return bean.getReps();
                        case 3: return bean.getWeight();
                        default: return null;
                    }
                }

                @Override
                public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                    WorkoutsExercisesBean bean = workoutsExercisesBeans.get(rowIndex);
                    int value;
                    try {
                        value = Integer.valueOf((String)aValue);
                        switch (columnIndex) {
                            case 1: bean.setSets(value);
                                break;
                            case 2: bean.setReps(Integer.valueOf((String)aValue));
                                break;
                            case 3: bean.setWeight(Integer.valueOf((String)aValue));
                                break;
                            default: break;
                        }
                        WorkoutExerciseManager.updateWorkoutExercise(bean);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a number");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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

    public boolean deleteWorkoutExercise(int sel) {
        boolean res = false;
        try {
            res = WorkoutExerciseManager.deleteWorkoutExercise(workoutsExercisesBeans.get(sel).getWo_id(), workoutsExercisesBeans.get(sel).getEx_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (res)
            updateTable(currentWOListSelection);
        return res;
    }
    public boolean insertWorkoutExercise(WorkoutsExercisesBean bean) {
        boolean res = WorkoutExerciseManager.insertWorkoutExercise(bean);
        if (res)
            updateTable(currentWOListSelection);
        return res;
    }

    public List<ExercisesBean> getExercises() {
        List<ExercisesBean> list = new ArrayList<>(10);
        try {
            list = ExerciseManager.getAllExercises();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean insertExercise(ExercisesBean bean) {
    	boolean res = false;
		try {
			res = ExerciseManager.insertExercise(bean);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return res;
    }
}


