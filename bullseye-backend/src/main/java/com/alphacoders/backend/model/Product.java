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

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category", discriminatorType = DiscriminatorType.STRING)

@Table(name = "product")
public  abstract class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	

	@Column(name = "subCategory")
	private String subCategory;
	
	@Column(name="category", insertable = false, updatable = false)
	protected String category;

	@Column(name = "unitPrice")
	private Float unitPrice;
	
	@Column(name = "stock")
	private int stock;
	
	public Product() {
		
	}
	
	
	public Product( String name, String description, String subCategory, String category, Float unitPrice, int stock) {
		super();
		this.name = name;
		this.description = description;
		this.subCategory = subCategory;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stock=stock;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}


	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", subCategory=" + subCategory
				+ ", category=" + category + ", unitPrice=" + unitPrice + ", stock=" + stock + "]";
	}




	

}
