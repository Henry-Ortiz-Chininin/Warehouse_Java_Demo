package com.alphacoders.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.KardexDTO;
import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.repository.IKardexRepository;


@RestController
@RequestMapping("/api/v1/kardex")
public class KardexController {

	@Autowired
	private IKardexRepository kardexRepository;
	
	public ResultDTO addKardex(KardexDTO kardex) {
		ResultDTO result = new ResultDTO();
		try {
			
			
			result.Status="OK";
		}catch(Exception ex) {
			result.Error=ex;
			result.Status="EX";
		}		
		
		return result;
	}
}
