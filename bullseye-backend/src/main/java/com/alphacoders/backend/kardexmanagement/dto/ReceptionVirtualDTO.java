package com.alphacoders.backend.kardexmanagement.dto;

import java.util.ArrayList;
import java.util.Date;

public class ReceptionVirtualDTO {
	public Long KardexID;
	public Date OperationDate;
	public String WaybillNumber;
	public String RequestNumber;

	public Long FromWarehouseID;
	public Long ToWarehouseID;
	
	public ArrayList<WarehouseDTO> Warehouses;
	public ArrayList<ProductDTO> Products;
	
	public ReceptionVirtualDTO() {
		// TODO Auto-generated constructor stub
	}

}
