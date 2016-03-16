package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import java.awt.*;


public class MainView extends JFrame {

    private static final Font HEADER_FONT = new Font("Verdana", Font.BOLD, 20);
    private static final Font LABEL_FONT = new Font("Verdana", Font.PLAIN, 16);
    private static final Font TEXTFIELD_FONT = new Font("Verdana", Font.PLAIN, 16);
    private static final Font LIST_FONT = new Font("Verdana", Font.PLAIN, 24);
    private static final Font TABLE_FONT = new Font("Verdana", Font.PLAIN, 18);

    private JTextField woNameTextField;
    private JTextArea woInfoTextArea;
    private JTextField woDateTextField;
    private JTextField exNameTextField;
    private JTextField exDescTextField;

    private JTextField woTypeTextField;

	private JLabel nameLabel, typeLabel, infoLabel, dateLabel, descLabel, exNameLabel;
    private JButton woAddButton;
    
    private JButton exAddButton;

    private JButton workoutExerciseDeleteButton;

    private JButton workoutExerciseAddButton;

    private JTable exerciseTable;

    private JList woList;

    private JTextField searchTextField;

    private JButton searchButton;

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getWorkoutExerciseAddButton() {
        return workoutExerciseAddButton;
    }
	public MainView() throws HeadlessException {

		setLayout(new GridBagLayout());

        JPanel leftpanel = createLeftpanel();
		JPanel bottomPanel = createBottomPanel();
        JPanel searchPanel = createSearchPanel();
       
		woList = new JList();
        woList.setFont(LIST_FONT);

        JScrollPane woListScrollPane = new JScrollPane(woList);

        exerciseTable = new JTable();
        exerciseTable.setFont(TABLE_FONT);
        JTableHeader header = exerciseTable.getTableHeader();
        header.setPreferredSize(new Dimension(150, 50));
        header.setMinimumSize(new Dimension(150, 50));
        header.setFont(HEADER_FONT);
        exerciseTable.setFillsViewportHeight(true);
        workoutExerciseDeleteButton = new JButton("DELETE");
        workoutExerciseAddButton = new JButton("ADD");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(leftpanel, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(bottomPanel, gbc);

        gbc.gridy = 2;
        gbc.gridheight = 1;
        add(searchPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 2;
        add(woListScrollPane, gbc);

        gbc.gridx = 2;
        gbc.gridheight = 2;
        add(new JScrollPane(exerciseTable), gbc);

        gbc.gridy = 2;
        gbc.gridheight = 1;
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(workoutExerciseDeleteButton);
        buttonPanel.add(workoutExerciseAddButton);
        add(buttonPanel, gbc);

        setTitle("Workout App");
        //setSize(1200, 800);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

    }

    public void clearForm() {
        woNameTextField.setText("");
        woTypeTextField.setText("");
        woInfoTextArea.setText("");
        woDateTextField.setText("");
    }

    public void clearAddExForm() {
        exNameTextField.setText("");
        exDescTextField.setText("");
    }

    public JButton getWorkoutExerciseDeleteButton() {
        return workoutExerciseDeleteButton;
    }

    public JTextField getWoNameTextField() {
        return woNameTextField;
    }

    public JTextField getWoTypeTextField() {
        return woTypeTextField;
    }

    public JTextArea getWoInfoTextArea() {
        return woInfoTextArea;
    }

    public JTextField getWoDateTextField() {
        return woDateTextField;
    }

    public JList getWoList() {
        return woList;
    }

    public JTable getExerciseTable() {
        return exerciseTable;
    }

    public JButton getWoAddButton() {
        return woAddButton;
    }

    private JPanel createLeftpanel() {
        final Insets insets = new Insets(2, 2, 2, 2);
		JPanel lp = new JPanel();
		lp.setLayout(new GridBagLayout());
		woNameTextField = makeTextField();
		woTypeTextField = new JTextField();
		woInfoTextArea = new JTextArea();
        woInfoTextArea.setRows(4);
		woDateTextField = new JTextField();
        nameLabel = makeLabel("Name : ");
        typeLabel = makeLabel("Type : ");
        infoLabel = makeLabel("Info : ");
        dateLabel = makeLabel("Date : ");

        woAddButton = new JButton("Add");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        lp.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		lp.add(woNameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        lp.add(typeLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		lp.add(woTypeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        lp.add(infoLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		lp.add(new JScrollPane(woInfoTextArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        lp.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		lp.add(woDateTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.gridwidth = 1;
        lp.add(woAddButton, gbc);

        Border leftPanelBorder = BorderFactory.createTitledBorder("Add workout");
        lp.setBorder(leftPanelBorder);
        return lp;
	}
    
    private JPanel createBottomPanel(){
    	
    	final Insets insets = new Insets(2, 2, 2, 2);
		JPanel lp = new JPanel();
		lp.setLayout(new GridBagLayout());
		exNameTextField = makeTextField();
		exDescTextField = new JTextField();
		
        exNameLabel = makeLabel("Name : ");
        descLabel = makeLabel("Description : ");

        exAddButton = new JButton("Add");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        lp.add(exNameLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		lp.add(exNameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        lp.add(descLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		lp.add(exDescTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.gridwidth = 1;
        lp.add(exAddButton, gbc);

        Border leftPanelBorder = BorderFactory.createTitledBorder("Add exercise");
        lp.setBorder(leftPanelBorder);
        return lp;
    	
    }
    
    public JTextField getExNameTextField() {
		return exNameTextField;
	}

	public JTextField getExDescTextField() {
		return exDescTextField;
	}

	public JButton getExAddButton() {
		return exAddButton;
	}

	private JLabel makeLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(LABEL_FONT);
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        return l;
    }

    private JTextField makeTextField() {
        JTextField tf = new JTextField();
        Dimension d = tf.getPreferredSize();
        d.width = 250;
        tf.setPreferredSize(d);
        tf.setFont(TEXTFIELD_FONT);
        return tf;
    }

    private JPanel createSearchPanel() {
        JPanel p = new JPanel();
        searchTextField = new JTextField();
        Dimension d = searchTextField.getPreferredSize();
        d.width = 250;
        searchTextField.setPreferredSize(d);
        searchButton = new JButton("Search");
        p.add(searchTextField);
        p.add(searchButton);
        return p;
    }

}
