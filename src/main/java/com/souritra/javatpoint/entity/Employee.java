package com.souritra.javatpoint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_002")
public class Employee {

	@Id
	private Long id;

	// only getter method for Id, no setter method
	public Long getId() {
		return id;
	}
	
	// only getter method for Id, no setter method
	// I just created as this is only way to set Id for now
	public void setId(Long id) {
		this.id = id;
	}

	private String firstName;

	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
