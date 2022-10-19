package com.alphacoders.backend.dto;

import java.util.Date;
import java.util.List;

public class KardexDTO {
	public Integer ID;
	public Date OperationDate;
	public Integer WarehouseID;
	public List<KardexProductDTO> Products;
	
}
