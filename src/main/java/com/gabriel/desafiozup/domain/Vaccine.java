package com.gabriel.desafiozup.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Vaccine implements Serializable{
	//Default version number
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date admDate;
	
	//There's no import because its belongs to the same class (both are domains)
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//Constructors
	public Vaccine() {
		
	}

	//Constructor using fields: All fields with exception LIST
	public Vaccine(Integer id, String name, Date admDate, User user) {
		super();
		this.id = id;
		this.name = name;
		this.admDate = admDate;
		this.setUser(user);
	}

	//Getters and Setters - For All
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAdmDate() {
		return admDate;
	}

	public void setAdmDate(Date admDate) {
		this.admDate = admDate;
	}
	
	//Getters and Setter for key
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//HashCode e Setters
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vaccine other = (Vaccine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
	
	
	
}
