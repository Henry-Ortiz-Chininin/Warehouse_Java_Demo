package com.alphacoders.backend.warehousemanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.model.Warehouse;
import com.alphacoders.backend.warehousemanagement.domain.IWarehouseManagement;
import com.alphacoders.backend.warehousemanagement.dto.WarehouseDTO;




/**
 * @author Alphacoders
 * @version v1.0
 * 
 * WarehouseHandler Controller is the class in charge of generating the 
 * REST API methods for interaction with the front-end.
 *
 */

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/warehousehandler")
public class WarehouseHandlerController {
	
	@Autowired
	private IWarehouseManagement repository;
	
	/**
	 * getAllWarehouses GET method to retrieve a list of
	 * object warehouses from the database.
	 * 
	 * */
	@GetMapping("/warehouses")
	public List<WarehouseDTO> getAllWarehouses(){
		return repository.findAll();
	}
	
	/**
	 * AddWarehouse POST method to generate a new warehouse data entry to the backend.
	 * @param WarehouseDTO warehouse,
	 * @return returns a ResultDTO result with status message.  
	 */
	@PostMapping("/newwarehouse")
	public ResultDTO addWarehouse(@RequestBody WarehouseDTO warehouse) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data = repository.createWarehouse(warehouse);
			result.Status = "OK";
		} catch (Exception e) {
			result.Status = "EX";
			result.Error = e;
		}
		
		return result;
	}
	
	/**
	 * updateWarehouse PUT method to UPDATE a data entry of the warehouse class already existing
	 * in the database.
	 * @param Long id,
	 * @param WarehouseDTO warehouse,
	 * @return returns a ResultDTO result with status message.  
	 */
	@PutMapping("/warehouse/{id}")
	public ResultDTO updateWarehouse(@PathVariable Long id, @RequestBody WarehouseDTO warehouse) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data = repository.updateWarehouse(id, warehouse);
			result.Status = "OK";
		} catch (Exception e) {
			result.Status = "EX";
			result.Error = e;
			
		}
		
		return result;
	}
	
	/**
	 * getWarehouseById GET method to retrieve an instance of a warehouse object
	 * based on the id.
	 * @param Long id,
	 * @return returns a ResultDTO result with status message.  
	 */
	@GetMapping("/warehouse/{id}")
	public ResultDTO getWarehouseById(@PathVariable Long id) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data = repository.getWarehouseById(id);
			result.Status = "OK";
		} catch (Exception e) {
			result.Status = "EX";
			result.Error = e;
		}
		
		return result;
	}

}
