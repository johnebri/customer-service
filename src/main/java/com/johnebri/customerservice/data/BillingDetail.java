package com.johnebri.customerservice.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "billing_details")
public class BillingDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "account_no", nullable=false, unique=true)
	@Size(min=10, message="Account Numbers must have 10 digits")
	private String accountNo;
	
	@Column(name = "tarrif")
	private Double tarrif;

	public BillingDetail() {
		
	}

	public BillingDetail(String accountNo, Double tarrif) {
		super();
		this.accountNo = accountNo;
		this.tarrif = tarrif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Double getTarrif() {
		return tarrif;
	}

	public void setTarrif(Double tarrif) {
		this.tarrif = tarrif;
	}
	
	

}
