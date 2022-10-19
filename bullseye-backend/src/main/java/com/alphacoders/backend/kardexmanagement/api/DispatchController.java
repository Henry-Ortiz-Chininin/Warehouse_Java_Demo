package com.alphacoders.backend.kardexmanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.kardexmanagement.domain.IDispatchService;
import com.alphacoders.backend.kardexmanagement.dto.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/kardex/dispatch")
public class DispatchController {
	
	@Autowired
	private IDispatchService repository;
	
	@GetMapping("new")
	public ResultDTO getNew(){
		
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.getNewDispatch();
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
	}



	@PostMapping("warehouse")
	public ResultDTO addDispatchToWarehouse(@RequestBody DispatchWarehouseDTO data) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.addDispatchToWarehouse(data);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}
	
	@PostMapping("client")
	public ResultDTO addDispatchToClient(@RequestBody DispatchClientDTO data) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.addDispatchToClient(data);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}

	@PostMapping("virtual")
	public ResultDTO addDispatchToVirtual(@RequestBody DispatchVirtualDTO data) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.addDispatchToVirtual(data);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}
	
}
