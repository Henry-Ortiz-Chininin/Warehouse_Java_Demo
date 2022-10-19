package com.alphacoders.backend.kardexmanagement.domain;


public class KardexDetailDomain {

	private Long Id;
	
	private Long KardexId;
	
	private int Quantity;
	
	private String MovementType;
	
	private Long ProductId;
	
	private String ProductName;
	
	private float Total;
	
	public KardexDetailDomain(Long kardexId, int quantity, String movementType, Long productId, float total) {
		super();
		this.KardexId = kardexId;
		this.Quantity = quantity;
		this.MovementType = movementType;
		this.ProductId = productId;
		this.Total = total;
	}

	public KardexDetailDomain(Long id, Long kardexId, int quantity, String movementType, Long productId, String productName,
			float total) {
		super();
		this.Id = id;
		this.KardexId = kardexId;
		this.Quantity = quantity;
		this.MovementType = movementType;
		this.ProductId = productId;
		this.ProductName = productName;
		this.Total = total;
	}

	public KardexDetailDomain(Long id, Long kardexId, int quantity, String movementType, Long productId, float total) {
		super();
		this.Id = id;
		this.KardexId = kardexId;
		this.Quantity = quantity;
		this.MovementType = movementType;
		this.ProductId = productId;
		this.Total = total;
	}

	public Long getId() {
		return this.Id;
	}

	public Long getKardexId() {
		return this.KardexId;
	}

	public int getQuantity() {
		return this.Quantity;
	}

	public String getMovementType() {
		return MovementType;
	}

	public Long getProductId() {
		return this.ProductId;
	}

	public String getProductName() {
		return this.ProductName;
	}

	public float getTotal() {
		return this.Total;
	}

	public KardexDetailDomain() {
		// TODO Auto-generated constructor stub
	}

}
