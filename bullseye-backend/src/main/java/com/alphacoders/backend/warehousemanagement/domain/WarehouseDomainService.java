package com.alphacoders.backend.warehousemanagement.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.DistributionCenter;
import com.alphacoders.backend.model.StoreWarehouse;
import com.alphacoders.backend.model.VirtualWarehouse;
import com.alphacoders.backend.model.Warehouse;
import com.alphacoders.backend.repository.WarehouseRepository;
import com.alphacoders.backend.warehousemanagement.dto.WarehouseDTO;

/**
 * @author Alphacoders
 * @version v1.0
 * 
 * WarehouseDomainService contains the business logic of the warehouse
 * object type implements IWarehouseManagement
 *
 */
@Service
public class WarehouseDomainService implements IWarehouseManagement{
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	public WarehouseDomainService() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<WarehouseDTO> findAll() {
		List<WarehouseDTO> warehouses=new ArrayList<WarehouseDTO>();
		
		warehouseRepository.findAll().forEach(w -> warehouses.add(new WarehouseDTO(w.getId(), w.getAddress(), w.getName(), w.getType())));

		return warehouses;		
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WarehouseDTO createWarehouse(WarehouseDTO warehouse) {
		List<Warehouse> warehouses=null;

		try {
			warehouses = warehouseRepository.findAll();
			warehouses = warehouses.stream().filter(e->Objects.equals(e.getName(), warehouse.name)).collect(Collectors.toList());

		}catch(Exception ex) {
			warehouses= new ArrayList<Warehouse>();
		}			
		if(!warehouses.isEmpty()) {
			throw new WarehouseNameAlreadyExistsException(warehouse.name);
		}			

		
		if(warehouse.type.equals("D")) {
			DistributionCenter dist = new DistributionCenter();
			dist.setAddress(warehouse.address);
			dist.setName(warehouse.name);
			warehouseRepository.save(dist);
	
		}
		if(warehouse.type.equals("S")) {
			StoreWarehouse st = new StoreWarehouse();
			st.setAddress(warehouse.address);
			st.setName(warehouse.name);
			warehouseRepository.save(st);
			
		}
		
		if(warehouse.type.equals("V")) {
			VirtualWarehouse vrt = new VirtualWarehouse();
			vrt.setAddress(warehouse.address);
			vrt.setName(warehouse.name);
			warehouseRepository.save(vrt);
		}
		
		
		return warehouse;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WarehouseDTO updateWarehouse(Long id, WarehouseDTO warehouse) {
		Warehouse wh = warehouseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("not found"));
		
		if(wh == null) {
			throw new WarehouseNotExistsException(warehouse.name + "not found");
		} else {
			wh.setAddress(warehouse.address);
			wh.setName(warehouse.name);
			warehouseRepository.save(wh);
		}
		return warehouse;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WarehouseDTO getWarehouseById(Long id) {
		Warehouse warehouse = warehouseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("not found"));
		
		WarehouseDTO warehouseFound = new WarehouseDTO(warehouse.getId(),warehouse.getAddress(),warehouse.getName(),warehouse.getType());
		
		return warehouseFound;
	}

}
