package Model;

import java.io.Serializable;
import java.sql.Date;

// Java Bean
public class WorkoutsBean implements Serializable {

	private static final long serialVersionUID = 3449721797498271010L;
	private int id;
	private String name, type, info;
	private Date date;

	// Constructor
	public WorkoutsBean() {

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
