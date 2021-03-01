package com.gabriel.desafiozup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class VaccineDTO implements Serializable{
	//Default version number
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotEmpty(message = "Campo deve ser preenchido.")
	@Length(min = 5, max = 80, message = "Campo deve conter entre 5 e 80 caracteres.")
	private String name;

	@NotNull(message = "Campo deve ser preenchido.")
	@Temporal(TemporalType.TIMESTAMP)
	private Date admDate;
	
	@NotEmpty(message = "Campo deve ser preenchido.")
	@Length(min = 7, max = 80, message = "Campo deve conter entre 7 e 80 caracteres.")
	@Email(message = "Um email valido deve ser preenchido.")
	private String userEmail;
	
	
	//Constructor
	public VaccineDTO() {
		
	}


	public VaccineDTO(Integer id, String name, Date admDate, String userEmail) {
		super();
		this.id = id;
		this.name = name;
		this.admDate = admDate;
		this.userEmail = userEmail;
	}
	
//	public VaccineDTO(Vaccine obj, User objUser) {
//		id = obj.getId();
//		name = obj.getName();
//		admDate = obj.getAdmDate();
//		user_id = objUser.getId();
//	}


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


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	
}
