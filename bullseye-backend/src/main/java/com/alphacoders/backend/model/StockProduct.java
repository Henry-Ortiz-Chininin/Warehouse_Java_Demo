package com.alphacoders.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="STOCK")
public class StockProduct {

	@Id
	private Long id;
	
	@Column(name="warehouse_id")
	private Long WharehouseID;

	@Column(name="product_id")
	private Long ProductID;
	
	@Column(name="last_update")
	private Date LastUpdate;
	
	@Column(name="quantity")
	private int Quantity;

	@Column(name="unit_price")
	private float UnitPrice;

	public StockProduct() {

	}

	public StockProduct(Long wharehouseID, Long productID) {
		super();
		WharehouseID = wharehouseID;
		ProductID = productID;
	}

	
	public StockProduct(Long wharehouseID, Long productID, Date lastUpdate, int quantity, float unitPrice) {
		super();
		this.id = (wharehouseID * 1000) + productID;
		this.WharehouseID = wharehouseID;
		ProductID = productID;
		LastUpdate = lastUpdate;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWharehouseID() {
		return WharehouseID;
	}

	public Long getProductID() {
		return ProductID;
	}

	public Date getLastUpdate() {
		return LastUpdate;
	}

	public int getQuantity() {
		return Quantity;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	
}
