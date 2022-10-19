package com.alphacoders.backend.productmanagement.dto;

public class ProductDTO {

	public Long id;
	public String name;
	public String description;
	public String category;
	public String subCategory;
	public Float unitPrice;
	public int stock;
	
	public ProductDTO() {}

	public ProductDTO(Long id, String name, String description, String category, String subCategory, Float unitPrice, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.unitPrice = unitPrice;
		this.stock = stock;
	}
	

	
	
}
