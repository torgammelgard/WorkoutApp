package View;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainView extends JFrame {

	private JTextField woNameTextField;
	private JTextField woTypeTextField;
	private JTextArea woInfoTextArea;
	private JTextField woDateTextField;
	
	public MainView() throws HeadlessException {
		
		setLayout(new GridLayout(1,3));
		JPanel leftpanel = createLeftpanel();
		add(leftpanel);
		
		
		setTitle("Workout App");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	private JPanel createLeftpanel() {
		JPanel lp = new JPanel();
		lp.setLayout(new BoxLayout(lp, BoxLayout.Y_AXIS));
		woNameTextField = new JTextField();
		woTypeTextField = new JTextField();
		woInfoTextArea = new JTextArea();
		woDateTextField = new JTextField();
		lp.add(woNameTextField);
		lp.add(woTypeTextField);
		lp.add(woInfoTextArea);
		lp.add(woDateTextField);
		
		return lp;
	}

}
