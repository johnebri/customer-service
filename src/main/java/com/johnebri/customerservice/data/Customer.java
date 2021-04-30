package com.johnebri.customerservice.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Size(min=2, message = "First name must have at least 2 characters")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotNull
	@Size(min=2, message = "Last name must have at least 2 characters")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@NotNull
	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billing_details_id")
	private BillingDetail billingDetail;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, BillingDetail billingDetail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.billingDetail = billingDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BillingDetail getBillingDetail() {
		return billingDetail;
	}

	public void setBillingDetail(BillingDetail billingDetail) {
		this.billingDetail = billingDetail;
	}
	
	

}
