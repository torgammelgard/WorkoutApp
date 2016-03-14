package Controller;

import View.MainView;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

public class Controller implements MouseListener, ActionListener {

    private static final String WORKOUT_ADD_ACTIONCOMMAND = "workouts_add_actioncommand";

    private Model model;
    private MainView mainView;

    public Controller(Model model, MainView mainView) {
        this.model = model;
        this.mainView = mainView;
        mainView.getWoList().addMouseListener(this);
        mainView.getWoAddButton().addActionListener(this);
        mainView.getWoAddButton().setActionCommand(WORKOUT_ADD_ACTIONCOMMAND);
        mainView.getWoList().setListData(model.getWoListModel());
        mainView.getExerciseTable().setModel(model.getTableModel());
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
        if (e.getActionCommand().equals(WORKOUT_ADD_ACTIONCOMMAND)){
            String name = mainView.getWoNameTextField().getText();
            String type = mainView.getWoTypeTextField().getText();
            String info = mainView.getWoInfoTextArea().getText();
            Date date = new Date(1); // TODO fix this date thing
            WorkoutsBean bean = new WorkoutsBean();
            if (name.equals("")){
                JOptionPane.showMessageDialog(mainView, "Name required", "Wrong", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (type.equals("")){
                JOptionPane.showMessageDialog(mainView, "Type required", "Wrong", JOptionPane.ERROR_MESSAGE);
                return;
            }
            bean.setName(name);
            bean.setType(type);
            bean.setInfo(info);
            bean.setDate(date);

            if (model.insertWorkout(bean))
                mainView.getWoList().setListData(model.getWoListModel());
        }
    }
}
