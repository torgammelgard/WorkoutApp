package View;

import Model.WorkoutManager;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.SQLException;


public class MainView extends JFrame {

	private JTextField woNameTextField;
	private JTextField woTypeTextField;
	private JTextArea woInfoTextArea;
	private JTextField woDateTextField;

	private JLabel nameLabel, typeLabel, infoLabel, dateLabel;
    private JButton woAddButton;

    public JList getWoList() {
        return woList;
    }

    private JList woList;

    private String[] columnNames = new String[]{"Name", "Sets", "Reps", "Weight"};

	public MainView() throws HeadlessException {
		
		setLayout(new GridLayout(1,3));
		JPanel leftpanel = createLeftpanel();
		woList = createWoList();
        JTable exerciseTable = createTable();


        add(leftpanel);
        add(woList);
        add(exerciseTable);

		setTitle("Workout App");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

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
        String[] workoutNames = null;
        try {
            workoutNames = WorkoutManager.getAllWoNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JList l = new JList(workoutNames);
        for (String s : workoutNames)
            System.out.println(s);

        return l;
    }

    private JTable createTable() {

        TableModel tm = new TableModel() {
            @Override
            public int getRowCount() {
                return 5;
            }

            @Override
            public int getColumnCount() {
                return 4;
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
                return 1;
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

        JTable table = new JTable(tm);
        return table;
    }
}
