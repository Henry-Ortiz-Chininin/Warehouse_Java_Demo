package com.alphacoders.backend.model;


import java.util.Date;

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
@Table(name="KARDEX")
public class Kardex {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="operation_date")
	private Date operationdate;

	@Column(name="warehouse_ins_id")
	private Long WarehouseInputID;

	@Column(name="warehouse_outs_id")
	private Long WarehouseOutputID;

	@Column(name="Waybill")
	private String Waybill;

	@Column(name="Invoice")
	private String Invoice;

	@Column(name="Purchase")
	private String Purchase;

	@Column(name="Client")
	private String Client;
	
	@Column(name="Provider")
	private String Provider;
	
	@Column(name="Request")
	private String Request;

	@Column(name="Type")
	private String Type;

	//DISPATCH
	
	public Kardex(Date operationdate, Long warehouseInputID, Long warehouseOutputID, String waybill,
			String invoice, String request, String clientName, String type) {
		super();
		this.operationdate = operationdate;
		this.WarehouseInputID = warehouseInputID;
		this.WarehouseOutputID = warehouseOutputID;
		this.Waybill = waybill;
		this.Invoice = invoice;
		this.Client = clientName;
		this.Request = request;
		this.Type=type;
	}
	
	public Kardex(Long id, Date operationdate, Long warehouseInputID, Long warehouseOutputID, String waybill,
			String invoice, String request, String clientName, String type) {
		super();
		this.operationdate = operationdate;
		this.WarehouseInputID = warehouseInputID;
		this.WarehouseOutputID = warehouseOutputID;
		this.Waybill = waybill;
		this.Invoice = invoice;
		this.Client = clientName;
		this.Request = request;
		this.Type=type;
	}

	
	//RECEPTION
	
	public Kardex(Date operationdate, Long warehouseInputID, Long warehouseOutputID, String waybill,
			String invoice, String purchase, String request, String providerName, String type) {
		super();
		this.operationdate = operationdate;
		this.WarehouseInputID = warehouseInputID;
		this.WarehouseOutputID = warehouseOutputID;
		this.Waybill = waybill;
		this.Invoice = invoice;
		this.Purchase = purchase;
		this.Provider=providerName;
		this.Request = request;
		this.Type=type;
	}
	
	public Kardex(Long id, Date operationdate, Long warehouseInputID, Long warehouseOutputID, String waybill,
			String invoice, String purchase, String request, String providerName, String type) {
		super();
		this.id = id;
		this.operationdate = operationdate;
		this.WarehouseInputID = warehouseInputID;
		this.WarehouseOutputID = warehouseOutputID;
		this.Waybill = waybill;
		this.Invoice = invoice;
		this.Purchase = purchase;
		this.Provider=providerName;
		this.Request = request;
		this.Type=type;
	}

	public Kardex(Date OperationDate, Long WarehouseInputID) {
		this.operationdate = OperationDate;
		this.WarehouseInputID=WarehouseInputID;
	}

	public Kardex() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOperationdate() {
		return operationdate;
	}

	public void setOperationdate(Date operationdate) {
		this.operationdate = operationdate;
	}

	public Long getWarehouseInputID() {
		return WarehouseInputID;
	}

	public void setWarehouseInputID(Long warehouseInputID) {
		WarehouseInputID = warehouseInputID;
	}

	public Long getWarehouseOutputID() {
		return WarehouseOutputID;
	}

	public void setWarehouseOutputID(Long warehouseOutputID) {
		WarehouseOutputID = warehouseOutputID;
	}

	public String getWaybill() {
		return Waybill;
	}

	public void setWaybill(String waybill) {
		Waybill = waybill;
	}

	public String getInvoice() {
		return Invoice;
	}

	public void setInvoice(String invoice) {
		Invoice = invoice;
	}

	public String getPurchase() {
		return Purchase;
	}

	public void setPurchase(String purchase) {
		Purchase = purchase;
	}

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public String getProvider() {
		return Provider;
	}

	public void setProvider(String provider) {
		Provider = provider;
	}

	public String getRequest() {
		return Request;
	}

	public void setRequest(String request) {
		Request = request;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	
	
	
}
