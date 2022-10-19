package com.alphacoders.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="KARDEX_DETAIL")
public class KardexDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="kardexid")
	private Long kardexId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="movement_type")
	private String movementType;
	
	@Column(name="productid")
	private Long productId;
	

	@Column(name="total")
	private float total;
	
	
	public KardexDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public KardexDetail(Long kardexId, int quantity, String movementType, Long productId, float total) {
		super();
		this.kardexId = kardexId;
		this.quantity = quantity;
		this.movementType = movementType;
		this.productId = productId;
		this.total = total;
	}

	public KardexDetail(Long id, Long kardexId, int quantity, String movementType, Long productId, float total) {
		super();
		this.id = id;
		this.kardexId = kardexId;
		this.quantity = quantity;
		this.movementType = movementType;
		this.productId = productId;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKardexId() {
		return kardexId;
	}

	public void setKardexId(Long kardexId) {
		this.kardexId = kardexId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	

}
