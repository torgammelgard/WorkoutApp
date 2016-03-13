import Controller.Controller;
import View.MainView;
import Model.Model;
import javax.swing.*;
import java.sql.SQLException;

public class Main {
	
	public static void main (String[] args) throws SQLException {
		Model model = new Model();
		SwingUtilities.invokeLater(() -> {
			MainView mView = new MainView();
			Controller controller = new Controller(model, mView);
		});
	}
}
