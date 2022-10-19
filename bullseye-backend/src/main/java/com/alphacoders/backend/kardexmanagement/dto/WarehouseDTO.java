package com.alphacoders.backend.kardexmanagement.dto;

public class WarehouseDTO {
	public Long WarehouseID;
	public String Name;
	public String Type;
	public Boolean Selected;
	
	public WarehouseDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public WarehouseDTO(Long ID, String Name, Boolean Selected) {
		this.WarehouseID = ID;
		this.Name=Name;
		this.Selected=Selected;
	}
	
	public WarehouseDTO(Long ID, String Name, String Type, Boolean Selected) {
		this.WarehouseID = ID;
		this.Name=Name;
		this.Type=Type;
		this.Selected=Selected;
	}

}
