package Controller;

import View.MainView;
import Model.Model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener {
    Model model;
    public Controller(Model model, MainView mainView) {
        this.model = model;
        mainView.getWoList().addMouseListener(this);
        mainView.getWoList().setListData(model.getWoListModel());
        mainView.getExerciseTable().setModel(model.getTableModel());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JList) {
            int id = ((JList) e.getSource()).getSelectedIndex();
            model.updateTable(id);
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
}
