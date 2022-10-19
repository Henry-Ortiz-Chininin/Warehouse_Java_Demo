package com.alphacoders.backend.kardexmanagement.dto;

import java.util.ArrayList;
import java.util.Date;

public class ReceptionDTO {
	public Long KardexID;
	public Date OperationDate;
	public String WaybillNumber;
	public String InvoiceNumber;
	public String PurchaseOrder;
	public String RequestNumber;
	public String ProviderName;
	public Long FromWarehouseID;
	public Long ToWarehouseID;
	
	public ArrayList<WarehouseDTO> Warehouses;
	public ArrayList<ProductDTO> Products;
	
	
	public ReceptionDTO() {

		
	}

}
