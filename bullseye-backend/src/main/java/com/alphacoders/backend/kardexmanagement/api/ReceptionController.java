package com.alphacoders.backend.kardexmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.kardexmanagement.domain.IReceptionService;
import com.alphacoders.backend.kardexmanagement.dto.DispatchDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionProviderDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionVirtualDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionWarehouseDTO;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/kardex/reception/")
public class ReceptionController {

	@Autowired
	private IReceptionService repository;
	
	public ReceptionController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("new")
	public ResultDTO getNew(){
		
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.getNewReception();
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
	}

	@PostMapping("warehouse")
	public ResultDTO addReceiptFromWarehouse(@RequestBody ReceptionWarehouseDTO data) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.addReceiptFromWarehouse(data);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}
	
	@PostMapping("provider")
	public ResultDTO addReceiptFromProvider(@RequestBody ReceptionProviderDTO data) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.addReceiptFromProvider(data);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}

	@PostMapping("virtual")
	public ResultDTO addReceiptFromVirtual(@RequestBody ReceptionVirtualDTO data) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.addReceiptFromVirtual(data);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}
	
}
