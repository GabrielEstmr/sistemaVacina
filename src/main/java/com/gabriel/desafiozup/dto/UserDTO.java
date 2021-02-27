package com.gabriel.desafiozup.dto;

import java.io.Serializable;
import java.util.Date;

import com.gabriel.desafiozup.domain.User;

public class UserDTO  implements Serializable{
	//Default version number
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private String cpf;
	private Date bday;
	
	//Constructor
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		id=obj.getId();
		name=obj.getName();
		email=obj.getEmail();
		cpf=obj.getCpf();
		bday=obj.getBday();
	}

	//Getters and Setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}
	
	

}
