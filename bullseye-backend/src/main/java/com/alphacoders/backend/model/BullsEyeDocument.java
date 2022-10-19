package com.alphacoders.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Represents a BullsEyeDocument object
 * @author Alphacoders
 * @version v1.0
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
@Table(name="DOCUMENT")
public abstract class BullsEyeDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	/**
	 * Represents the issue date of the document object
	 * */
	@Column(name = "emission_date")
	private Date emissionDate;
	
	@Column(name="type", insertable=false, updatable = false)
	protected String type;
	
	public BullsEyeDocument() {
		
	}
	
	/**
	 * BullsEyeDocument Constructor.
	 * */
	public BullsEyeDocument(String name, String address, Date emissionDate) {
		super();
		this.name = name;
		this.address = address;
		this.emissionDate = emissionDate;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEmissionDate() {
		return emissionDate;
	}

	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
	
	
	
	

}
