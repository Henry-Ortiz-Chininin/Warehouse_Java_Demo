package com.alphacoders.backend.warehousemanagement.domain;
import com.alphacoders.backend.model.Warehouse;
import com.alphacoders.backend.warehousemanagement.dto.WarehouseDTO;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IWarehouseManagement {
	
	List<WarehouseDTO> findAll();
	WarehouseDTO createWarehouse(WarehouseDTO warehouse);
	WarehouseDTO updateWarehouse(Long id ,WarehouseDTO warehouse);
	WarehouseDTO getWarehouseById(Long id );

}
