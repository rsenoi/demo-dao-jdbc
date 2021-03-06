package br.com.trainning.model;

import java.io.Serializable;
import java.sql.Date;

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	private int Id;
    private String Name;
    
    public Department() {
    } 

	public Department(int id, String name) {
		Id = id;
		Name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (Id != other.Id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [Id=" + Id + ", Name=" + Name + "]";
	}


    
}
