package com.alphacoders.backend.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * In movement representation
 * @author Alphacoders
 * @version v1.0
 * 
 * */

@Entity
@DiscriminatorValue("IN")
public class InMovement extends Movement {

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
