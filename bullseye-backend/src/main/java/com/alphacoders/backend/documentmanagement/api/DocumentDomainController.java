package com.alphacoders.backend.documentmanagement.api;

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

import com.alphacoders.backend.documentmanagement.domain.IDocumentManagement;
import com.alphacoders.backend.documentmanagement.dto.BullsEyeDocumentDTO;
import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.model.BullsEyeDocument;

/**
 * @author Alphacoders
 * @version v1.0
 * 
 * DocumentDomainController is the class in charge of generating the REST API
 * methods for interaction with the front-end.
 *
 */
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/documenthandler")
public class DocumentDomainController{
	
	@Autowired
	private IDocumentManagement repository;
	
	/**
	 * getAllDocuments GET method to retrieve a list of
	 * object BullsEyeDocument from the database.
	 * 
	 * */
	@GetMapping("/documents")
	public List<BullsEyeDocument> getAllDocuments(){
		return repository.findAll();
	}
	
	/**
	 * addDocument POST method to generate a new BullsEyeDocument data entry to the backend.
	 * @param BullsEyeDocumentDTO document,
	 * @return returns a ResultDTO result with status message.  
	 */
	@PostMapping("/newdocument")
	public ResultDTO addDocument(@RequestBody BullsEyeDocumentDTO document) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data = repository.createDocument(document);
			result.Status = "OK";
		} catch (Exception e) {
			result.Status = "EX";
			result.Error = e;
		}
		
		return result;
	}
	
	/**
	 * updateDocument PUT method to UPDATE a data entry of the BullsEyeDocument
	 * class already existing in the database.
	 * @param Long id,
	 * @param BullsEyeDocumentDTO document,
	 * @return returns a ResultDTO result with status message.  
	 */
	@PutMapping("/document/{id}")
	public ResultDTO updateDocument(@PathVariable Long id, @RequestBody BullsEyeDocumentDTO document) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data = repository.updateDocument(id, document);
			result.Status = "OK";
		} catch (Exception e) {
			result.Status = "EX";
			result.Error = e;
		}
		
		return result;
	}
	
	/**
	 * getDocumentById GET method to retrieve an instance of a warehouse object
	 * based on the id.
	 * @param Long id,
	 * @return returns a ResultDTO result with status message.  
	 */
	@GetMapping("/document/{id}")
	public ResultDTO getDocumentById(@PathVariable Long id) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data = repository.getDocumentByID(id);
			result.Status = "OK";
		} catch (Exception e) {
			result.Status = "EX";
			result.Error = e;
		}
		
		return result;
	}
}
