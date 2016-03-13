package View;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame {

	private JTextField woNameTextField;
	private JTextField woTypeTextField;
	private JTextArea woInfoTextArea;
	private JTextField woDateTextField;

	private JLabel nameLabel, typeLabel, infoLabel, dateLabel;
    private JButton woAddButton;
    private JTable exerciseTable;

    private JList woList;

	public MainView() throws HeadlessException {

		setLayout(new GridLayout(1,3));
		JPanel leftpanel = createLeftpanel();
		woList = createWoList();
        exerciseTable = createTable();


        add(leftpanel);
        add(woList);
        add(exerciseTable);

		setTitle("Workout App");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

    public JList getWoList() {
        return woList;
    }

    public JTable getExerciseTable() {
        return exerciseTable;
    }

	private JPanel createLeftpanel() {
		JPanel lp = new JPanel();
		lp.setLayout(new GridLayout(5, 2));
		woNameTextField = new JTextField();
		woTypeTextField = new JTextField();
		woInfoTextArea = new JTextArea();
		woDateTextField = new JTextField();

        nameLabel = new JLabel("Name : ");
        typeLabel = new JLabel("Type : ");
        infoLabel = new JLabel("Info : ");
        dateLabel = new JLabel("Date : ");

        woAddButton = new JButton("Add");

        lp.add(nameLabel);
		lp.add(woNameTextField);
        lp.add(typeLabel);
		lp.add(woTypeTextField);
        lp.add(infoLabel);
		lp.add(woInfoTextArea);
        lp.add(dateLabel);
		lp.add(woDateTextField);
        lp.add(woAddButton);

        setPreferredSize(new Dimension(500, 600));
		return lp;
	}

    private JList createWoList() {
        JList l = new JList();
        return l;
    }

    private JTable createTable() {

        JTable table = new JTable();
        return table;
    }
}
