import Controller.Controller;
import View.MainView;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by torgammelgard on 2016-03-10.
 */
public class Main {
	
	public static void main (String[] args) throws SQLException {
		
		SwingUtilities.invokeLater(() -> {
			MainView mView = new MainView();
			Controller controller = new Controller(mView);
		});
	}
}
