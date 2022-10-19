package com.alphacoders.backend.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Represents a Warehouse object
 * @author Alphacoders
 * @version v1.0
 * 
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)

@Table(name="WAREHOUSE")
public abstract class Warehouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "address")
	private String address;
	

	@Column(name = "name")
	private String name;
	

	@Column(name="type", insertable = false, updatable = false)
	protected String type;


	public Warehouse() {}
	
	public Warehouse(String address, String name, String type) {
		super();
		this.address = address;
		this.name = name;
		this.type = type;
	}


	public void setId(long id) {
		this.id = id;
	}




	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Long getId() {
		return id;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%s%d %s - %s",this.type,this.id, this.name,this.address); 

	}




}
