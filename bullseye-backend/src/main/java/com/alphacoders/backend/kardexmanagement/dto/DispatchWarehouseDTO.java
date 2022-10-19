package com.alphacoders.backend.kardexmanagement.dto;

import java.util.ArrayList;
import java.util.Date;

public class DispatchWarehouseDTO {
	public Date OperationDate;
	public String WaybillNumber;
	public String RequestNumber;

	//Origin
	public Long FromWarehouseID;
	//Destinations
	public Long ToWarehouseID;
	
	public ArrayList<WarehouseDTO> Warehouses;
	public ArrayList<ProductDTO> Products;
	
	public DispatchWarehouseDTO() {
		// TODO Auto-generated constructor stub
	}

}
