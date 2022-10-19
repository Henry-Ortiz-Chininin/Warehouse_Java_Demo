package com.alphacoders.backend.kardexmanagement.dto;

import java.util.ArrayList;
import java.util.Date;

public class DispatchVirtualDTO {
	public Date OperationDate;
	public String WaybillNumber;
	public String RequestNumber;

	//Origin
	public Long FromWarehouseID;
	//Destinations
	public Long ToVirtualStoreID;
	
	public ArrayList<WarehouseDTO> Warehouses;
	public ArrayList<ProductDTO> Products;
	
	public DispatchVirtualDTO() {
		// TODO Auto-generated constructor stub
	}

}
