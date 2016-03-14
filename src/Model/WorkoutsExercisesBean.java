package Model;

import java.io.Serializable;

// Java Bean
public class WorkoutsExercisesBean implements Serializable {

	private static final long serialVersionUID = 6354424985720574186L;
	private int wo_id, ex_id;
	private int sets, reps, weight;
	
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

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
