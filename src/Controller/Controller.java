package Controller;

import Model.*;
import View.AddExPanel;
import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;

public class Controller implements MouseListener, ActionListener {

    private static final String WORKOUT_ADD_ACTIONCOMMAND = "workouts_add_actioncommand";
    private static final String WORKOUT_EXERCISE_DELETE_ACTIONCOMMAND = "workout_exercise_delete_actioncommand";
    private static final String WORKOUT_EXERCISE_ADD_ACTIONCOMMAND = "workout_exercise_add_actioncommand";
    private static final String SEARCH_WORKOUTS_ACTIONCOMMAND = "search_workouts_actioncommand";

    private Model model;
    private MainView mainView;

    public Controller(Model model, MainView mainView) {
        this.model = model;
        this.mainView = mainView;
        mainView.getWoList().addMouseListener(this);
        mainView.getWoAddButton().addActionListener(this);
        mainView.getWoAddButton().setActionCommand(WORKOUT_ADD_ACTIONCOMMAND);
        mainView.getSearchButton().addActionListener(this);
        mainView.getSearchButton().setActionCommand(SEARCH_WORKOUTS_ACTIONCOMMAND);
        mainView.getWorkoutExerciseDeleteButton().addActionListener(this);
        mainView.getWorkoutExerciseDeleteButton().setActionCommand(WORKOUT_EXERCISE_DELETE_ACTIONCOMMAND);
        mainView.getWorkoutExerciseAddButton().addActionListener(this);
        mainView.getWorkoutExerciseAddButton().setActionCommand(WORKOUT_EXERCISE_ADD_ACTIONCOMMAND);
        mainView.getWoList().setListData(model.getWoListModel());
        mainView.getExerciseTable().setModel(model.getTableModel());
        mainView.getExerciseTable().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JList) {
            int selectionIndex = ((JList) e.getSource()).getSelectedIndex();
            model.updateTable(selectionIndex);
            mainView.getExerciseTable().setModel(model.getTableModel());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(WORKOUT_ADD_ACTIONCOMMAND)) {
            String name = mainView.getWoNameTextField().getText();
            String type = mainView.getWoTypeTextField().getText();
            String info = mainView.getWoInfoTextArea().getText();
            Date date = new Date(1); // TODO fix this date thing
            WorkoutsBean bean = new WorkoutsBean();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(mainView, "Name required", "Wrong", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (type.equals("")) {
                JOptionPane.showMessageDialog(mainView, "Type required", "Wrong", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bean.setName(name);
            bean.setType(type);
            bean.setInfo(info);
            bean.setDate(date);

            if (model.insertWorkout(bean)) {
                mainView.getWoList().setListData(model.getWoListModel());
                mainView.clearForm();
            }
        } else if (e.getActionCommand().equals(WORKOUT_EXERCISE_DELETE_ACTIONCOMMAND)) {
            int sel = mainView.getExerciseTable().getSelectedRow();
            if (sel != -1)
                model.deleteExercise(sel);
        } else if (e.getActionCommand().equals(SEARCH_WORKOUTS_ACTIONCOMMAND)) {
            model.updateSearchList(mainView.getSearchTextField().getText());
            JList list = mainView.getWoList();
            String[] workouts = model.getWoListModel();
            list.setListData(workouts);
        } else if (e.getActionCommand().equals(WORKOUT_EXERCISE_ADD_ACTIONCOMMAND)) {
            // Ask the user for some information
            List list = model.getExercises();
            AddExPanel addExPanel = new AddExPanel((ExercisesBean[]) list.toArray(new ExercisesBean[list.size()]));
            JOptionPane.showConfirmDialog(mainView, addExPanel);
            WorkoutsExercisesBean partialBean = addExPanel.getWorkoutExerciseBean();

            int workoutID = model.getWorkoutIDForSelection(mainView.getWoList().getSelectedIndex());
            partialBean.setWo_id(workoutID);

            model.insertWorkoutExercise(partialBean);
        }
    }
}
