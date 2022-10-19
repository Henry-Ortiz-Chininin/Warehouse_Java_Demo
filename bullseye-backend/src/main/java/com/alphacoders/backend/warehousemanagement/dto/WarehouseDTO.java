package com.alphacoders.backend.warehousemanagement.dto;

public class WarehouseDTO {
	public Long id;
	public String address;
	public String name;
	public String type;
	
	public WarehouseDTO(Long ID, String address, String name, String type) {
		this.id=ID;
		this.address=address;
		this.name=name;
		this.type=type;
				
	}
	public WarehouseDTO() {}
	
}
