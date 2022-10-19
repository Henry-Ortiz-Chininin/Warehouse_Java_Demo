package com.alphacoders.backend.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Purchase order representation
 * @author Alphacoders
 * @version v1.0
 * 
 * */
@Entity
@DiscriminatorValue("PO")
public class PurchaseOrder extends BullsEyeDocument{


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
	public String getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		super.setType(type);
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
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public Date getEmissionDate() {
		// TODO Auto-generated method stub
		return super.getEmissionDate();
	}

	@Override
	public void setEmissionDate(Date emissionDate) {
		// TODO Auto-generated method stub
		super.setEmissionDate(emissionDate);
	}

}
