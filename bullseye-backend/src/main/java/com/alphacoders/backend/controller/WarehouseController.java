package com.alphacoders.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.dto.WarehouseDTO;
import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.DistributionCenter;
import com.alphacoders.backend.model.StoreWarehouse;
import com.alphacoders.backend.model.VirtualWarehouse;
import com.alphacoders.backend.model.Warehouse;
import com.alphacoders.backend.repository.WarehouseRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	
	@GetMapping("/list")
	public List<Warehouse> getAllWarehouse(){
		return (List<Warehouse>) warehouseRepository.findAll();	
		}
	
	@PostMapping("/create")
	public ResultDTO addWarehouse(@RequestBody WarehouseDTO warehouse) {
		ResultDTO result = new ResultDTO();
		result.Data = warehouse;
		
		try {
			if(warehouse.type.equals("D")) {
				DistributionCenter dist = new DistributionCenter();
				dist.setAddress(warehouse.address);
				dist.setName(warehouse.name);
				warehouseRepository.save(dist);
				result.Status="OK";
			}
			if(warehouse.type.equals("S")) {
				StoreWarehouse st = new StoreWarehouse();
				st.setAddress(warehouse.address);
				st.setName(warehouse.name);
				warehouseRepository.save(st);
				result.Status="OK";
			}
			if(warehouse.type.equals("V")) {
				VirtualWarehouse vrt = new VirtualWarehouse();
				vrt.setAddress(warehouse.address);
				vrt.setName(warehouse.name);
				warehouseRepository.save(vrt);
				result.Status="OK";
			}
		} catch (Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}
		
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResultDTO> getWarehouseById(@PathVariable Long id){
		ResultDTO result = new ResultDTO();
		
		Optional<Warehouse> obj = warehouseRepository.findById(id);
		
		try {
			if(obj != null) {
				result.Data = obj;
				result.Status="OK";
			}
		} catch (Exception ex) {
			result.Status="EX";
			result.Data= obj;
		}
		return ResponseEntity.ok(result);
	}
	

	@PutMapping("/warehouses/{id}")
	public ResponseEntity<ResultDTO> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseDTO warehouseDetail){


		ResultDTO result = new ResultDTO();
		
		//Search warehouse based on the id.
		Warehouse wh = warehouseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no warehouse found with id: " + id));
		
		//assign values to our DTO
		result.Data = wh;
		try {
			if(wh == null) {
				result.Status = "NO FOUND";
				result.Data = wh;
			} else {
				result.Status ="OK";
				wh.setName(warehouseDetail.name);
				wh.setAddress(warehouseDetail.address);
				warehouseRepository.save(wh);
				result.Data = wh;
			}
		} catch (Exception ex) {
			result.Status = "EX";
			result.Error = ex;
		}
		return ResponseEntity.ok(result);
	
	}
	
}
