package com.alphacoders.backend.kardexmanagement.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alphacoders.backend.kardexmanagement.dto.*;
import com.alphacoders.backend.model.*;
import com.alphacoders.backend.repository.IKardexRepository;


public class KardexDomain {
	
	private Long KardexID;
	private Date OperationDate;
	
	public Date getOperationDate() {
		return OperationDate;
	}

	public void setOperationDate(Date operationDate) {
		OperationDate = operationDate;
	}

	public Long getKardexID() {
		return KardexID;
	}

	public void setKardexID(Long kardexID) {
		KardexID = kardexID;
	}

}
