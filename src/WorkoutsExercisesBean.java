import java.io.Serializable;

// Java Bean
public class WorkoutsExercisesBean implements Serializable {

	private static final long serialVersionUID = 6354424985720574186L;
	private int wo_id, ex_id;
	private String sets, reps, weight;
	
	// Constructor
	public WorkoutsExercisesBean(){
		
		
	}
	// Getters and Setters
	public int getWo_id() {
		return wo_id;
	}

	public void setWo_id(int wo_id) {
		this.wo_id = wo_id;
	}

	public int getEx_id() {
		return ex_id;
	}

	public void setEx_id(int ex_id) {
		this.ex_id = ex_id;
	}

	public String getSets() {
		return sets;
	}

	public void setSets(String sets) {
		this.sets = sets;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
}
