import java.sql.SQLException;

import javax.swing.SwingUtilities;

import Model.WorkoutManager;
import View.MainView;

/**
 * Created by torgammelgard on 2016-03-10.
 */
public class Main {
	
	public static void main (String[] args) throws SQLException {
		
		SwingUtilities.invokeLater(() -> new MainView());
		WorkoutManager.getAllRows();
	}
}
