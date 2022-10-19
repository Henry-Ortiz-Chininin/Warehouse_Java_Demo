package com.alphacoders.backend.kardexmanagement.dto;

import java.util.ArrayList;
import java.util.Date;

public class DispatchClientDTO {
	public Date OperationDate;
	public String InvoiceNumber;

	//Origin
	public Long FromWarehouseID;
	//Destinations
	public String ClientName;
	
	public ArrayList<WarehouseDTO> Warehouses;
	public ArrayList<ProductDTO> Products;
	

	public DispatchClientDTO() {
		// TODO Auto-generated constructor stub
	}

}
