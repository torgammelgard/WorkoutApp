package View;

import Model.ExercisesBean;
import Model.WorkoutsExercisesBean;
import javax.swing.*;

public class AddExPanel extends JPanel {
    JTextField setsTextField;
    JTextField repsTextField;
    JTextField weightTextField;
    JList<String> list;
    ExercisesBean[] exercises;
    JLabel setsLabel;
    JLabel repsLabel;
    JLabel weightLabel;

    public AddExPanel(ExercisesBean[] exercises) {
        super();
        this.exercises = exercises;
        
        setsLabel = new JLabel(" Sets:");
        repsLabel = new JLabel(" Reps:");
        weightLabel = new JLabel(" Weight:");
        
        setsTextField = new JTextField(5);
        repsTextField = new JTextField(5);
        weightTextField = new JTextField(5);

        String[] names = new String[exercises.length];
        int i = 0;
        for (ExercisesBean exercise : exercises) {
            names[i++] = exercise.getName();
        }
        list = new JList<>(names);

        add(new JScrollPane(list));
   
        add(setsLabel);
        add(setsTextField);
        add(repsLabel);
        add(repsTextField);
        add(weightLabel);
        add(weightTextField);
       
    }

    public WorkoutsExercisesBean getWorkoutExerciseBean() {
        WorkoutsExercisesBean bean = new WorkoutsExercisesBean();
        int sel = list.getSelectedIndex();
        if (sel == -1)
            return bean;
        int id = exercises[sel].getId();
        bean.setEx_id(id);
        bean.setSets(Integer.valueOf(setsTextField.getText()));
        bean.setReps(Integer.valueOf(repsTextField.getText()));
        bean.setWeight(Integer.valueOf(weightTextField.getText()));
        return bean;
    }
}
