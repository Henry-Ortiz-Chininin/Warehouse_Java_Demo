package com.alphacoders.backend.kardexmanagement.domain;

import java.util.Date;

import com.alphacoders.backend.model.StockProduct;

public class StockDomain {
	private Long WarehouseID;
	private Long ProductID;
	private int Quantity;
	private float UnitPrice;
	private StockProduct model;
	private float TotalPrice;
	
	public StockProduct getModel() {
		model = new StockProduct(this.WarehouseID, this.ProductID, new Date(), this.Quantity, this.UnitPrice);
		return model;
	}

	public StockDomain() {
		// TODO Auto-generated constructor stub
	}

	public Long getWarehouseID() {
		return WarehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		WarehouseID = warehouseID;
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long productID) {
		ProductID = productID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}

	public StockDomain(Long warehouseID, Long productID, int quantity, float unitPrice) {
		super();
		WarehouseID = warehouseID;
		ProductID = productID;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}

	public float getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.TotalPrice = totalPrice;
		this.UnitPrice = this.TotalPrice/this.Quantity;
	}
	
	
	

}
