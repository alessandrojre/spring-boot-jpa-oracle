package com.avatar.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getCustomerById", procedureName = "GETCUSTOMERBYID", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_customerid", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_name", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_email", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_createdDate", type = Date.class)

		}, resultClasses = Customer.class),
		@NamedStoredProcedureQuery(name = "getProcedureCursor", procedureName = "GETCUSTOMERCURSOR", parameters = {
					@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)

		}, resultClasses = Customer.class),
		@NamedStoredProcedureQuery(name = "getProcedureCursorById", procedureName = "GETCUSTOMERCURSORBYID", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cursor_id", type = Long.class),
				@StoredProcedureParameter(name ="p_recordset",mode = ParameterMode.REF_CURSOR, type = void.class)

	}, resultClasses = Customer.class)})
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/mm/dd hh:mm:ss")
	private Date createdDate;

	public Customer() {

	}

	public Customer(Customer customer) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "TestElementProcedure [name=" + name + ", email=" + email + ",fecha=" + createdDate + "]";
	}

}
