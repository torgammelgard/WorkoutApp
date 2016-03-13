package View;

import javax.swing.*;
import javax.swing.border.Border;
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

    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Font TEXTFIELD_FONT = new Font("Arial", Font.PLAIN, 16);


	public MainView() throws HeadlessException {

		setLayout(new GridBagLayout());
		JPanel leftpanel = createLeftpanel();
		woList = new JList();
        JScrollPane woListScrollPane = new JScrollPane(woList);
        exerciseTable = new JTable();
        exerciseTable.setFillsViewportHeight(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(leftpanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        add(woListScrollPane, gbc);

        gbc.gridx = 2;
        add(new JScrollPane(exerciseTable), gbc);


        setTitle("Workout App");
		setSize(1000, 600);
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

        Border leftPanelBorder = BorderFactory.createTitledBorder("Add exercise");
        lp.setBorder(leftPanelBorder);
        return lp;
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
}
