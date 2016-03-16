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

    public AddExPanel(ExercisesBean[] exercises) {
        super();
        this.exercises = exercises;
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
        add(setsTextField);
        add(repsTextField);
        add(weightTextField);

    }

    public WorkoutsExercisesBean getWorkoutExerciseBean() {
        WorkoutsExercisesBean bean = new WorkoutsExercisesBean();
        int sel = list.getSelectedIndex();
        if (sel == -1)
            return null;
        int id = exercises[sel].getId();
        bean.setEx_id(id);
        try {
            int sets = Integer.valueOf(setsTextField.getText());
            int reps = Integer.valueOf(repsTextField.getText());
            int weight = Integer.valueOf(weightTextField.getText());
            bean.setSets(sets);
            bean.setReps(reps);
            bean.setWeight(weight);
        } catch (NumberFormatException e) {
            System.out.println("Couldn't convert field values into numbers");
            return null;
        }
        return bean;
    }
}
