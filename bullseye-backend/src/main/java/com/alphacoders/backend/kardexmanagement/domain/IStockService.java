package com.alphacoders.backend.kardexmanagement.domain;

import java.util.List;

public interface IStockService {

	StockDomain getProductStockByWarehouse(Long WarehouseID, Long ProductID);
	StockDomain getProductStock(Long ProductID);
	
	List<StockDomain> getStockByWarehouse(Long Warehouse);
	List<StockDomain> getStockByProduct(Long ProductID);
}