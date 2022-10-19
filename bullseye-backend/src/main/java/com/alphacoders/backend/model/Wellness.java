package com.alphacoders.backend.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WELLNESS")
public class Wellness extends Product{

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return super.getStock();
	}

	@Override
	public void setStock(int stock) {
		// TODO Auto-generated method stub
		super.setStock(stock);
	}

	@Override
	public Float getUnitPrice() {
		// TODO Auto-generated method stub
		return super.getUnitPrice();
	}

	@Override
	public void setUnitPrice(Float unitPrice) {
		// TODO Auto-generated method stub
		super.setUnitPrice(unitPrice);
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription();
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		super.setDescription(description);
	}

	@Override
	public String getSubCategory() {
		// TODO Auto-generated method stub
		return super.getSubCategory();
	}

	@Override
	public void setSubCategory(String subCategory) {
		// TODO Auto-generated method stub
		super.setSubCategory(subCategory);
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return super.getCategory();
	}

	@Override
	public void setCategory(String category) {
		// TODO Auto-generated method stub
		super.setCategory(category);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Wellness() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wellness(String name, String description, String subCategory, String category, Float unitPrice, int stock) {
		super(name, description, subCategory, category, unitPrice, stock);
		// TODO Auto-generated constructor stub
	}



}
