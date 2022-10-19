package com.alphacoders.backend.reports.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reports")
public class ReportsController {

	public ReportsController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("stockwarehouse")
	public ResultDTO getStockByWarehouse(){
		
		return new ResultDTO();
	}
	
	@GetMapping("stockproduct")
	public ResultDTO getStockByProduct(){
		
		return new ResultDTO();
	}
	
}
