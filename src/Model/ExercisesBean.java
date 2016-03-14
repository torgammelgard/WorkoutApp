package Model;

import java.io.Serializable;

// Java Bean
public class ExercisesBean implements Serializable {

	private static final long serialVersionUID = -6536710201863534184L;
	private int id;
	private String name, description;

	// Constructor
	public ExercisesBean() {

	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
