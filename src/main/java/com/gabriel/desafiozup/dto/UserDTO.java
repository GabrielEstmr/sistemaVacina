package com.gabriel.desafiozup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gabriel.desafiozup.domain.User;


public class UserDTO  implements Serializable{
	//Default version number
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	

	@NotEmpty(message = "Campo deve ser preenchido.")
	@Length(min = 5, max = 80, message = "Campo deve conter entre 5 e 80 caracteres.")
	private String name;
	
	@NotEmpty(message = "Campo deve ser preenchido.")
	@Length(min = 7, max = 80, message = "Campo deve conter entre 7 e 80 caracteres.")
	@Email(message = "Um email valido deve ser preenchido.")
	private String email;
	
	@Length(min = 14, max = 14, message = "CPF deve ser no formato XXX.XXX.XXX-XX")
	@NotEmpty(message = "Campo deve ser preenchido.")
	private String cpf;
	
	@NotNull(message = "Campo deve ser preenchido.")
	@Temporal(TemporalType.TIMESTAMP)
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
