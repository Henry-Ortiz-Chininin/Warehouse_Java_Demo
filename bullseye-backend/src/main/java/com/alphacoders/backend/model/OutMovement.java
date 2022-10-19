package com.alphacoders.backend.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Out movement representation
 * 
 * @author Alphacoders
 * @version v1.0
 * */
@Entity
@DiscriminatorValue("OUT")
public class OutMovement extends Movement{

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public Date getDate() {
		return super.getDate();
	}

	@Override
	public void setDate(Date date) {
		super.setDate(date);
	}
	

}
