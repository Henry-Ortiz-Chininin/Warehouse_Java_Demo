package com.alphacoders.backend.kardexmanagement.dto;

import java.util.ArrayList;
import java.util.Date;

public class DispatchDTO {

	public Date OperationDate;
	public String WaybillNumber;
	public String InvoiceNumber;
	public String RequestNumber;

	//Origin
	public Long FromWarehouseID;
	//Destinations
	public String ClientName;
	public Long ToWarehouseID;
	public Long ToVirtualStoreID;
	
	public ArrayList<WarehouseDTO> Warehouses;
	public ArrayList<ProductDTO> Products;
	
	public DispatchDTO() {
		// TODO Auto-generated constructor stub
	}

}
