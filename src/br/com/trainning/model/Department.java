package br.com.trainning.model;

import java.io.Serializable;
import java.sql.Date;

public class Department implements Serializable {

    private int Id;
    private String Name;
    
    public Department() {
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


    
}
