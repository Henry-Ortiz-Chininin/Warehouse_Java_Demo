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

import com.alphacoders.backend.dto.BullsEyeDocumentDTO;
import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.BullsEyeDocument;
import com.alphacoders.backend.model.Invoice;
import com.alphacoders.backend.model.PurchaseOrder;
import com.alphacoders.backend.model.ReturningBill;
import com.alphacoders.backend.model.Waybill;
import com.alphacoders.backend.repository.DocumentRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController{
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@GetMapping("/list")
	public List<BullsEyeDocument> getAllDocuments(){
		return (List<BullsEyeDocument>) documentRepository.findAll();
	}
	
	@PostMapping("/create")
	public ResultDTO addDocument(@RequestBody BullsEyeDocumentDTO document) {
		ResultDTO result = new ResultDTO();
		result.Data = document;
		
		try {
			if(document.document_type.equals("I")) {
				Invoice invoice = new Invoice();
				invoice.setAddress(document.address);
				invoice.setEmissionDate(document.emissionDate);
				invoice.setName(document.name);
				documentRepository.save(invoice);
				result.Status ="OK";
			}
			if(document.document_type.equals("W")) {
				Waybill waybill = new Waybill();
				waybill.setAddress(document.address);
				waybill.setEmissionDate(document.emissionDate);
				waybill.setName(document.name);
				documentRepository.save(waybill);
				result.Status ="OK";
			}
			if(document.document_type.equals("R")) {
				ReturningBill rBill = new ReturningBill();
				rBill.setAddress(document.address);
				rBill.setEmissionDate(document.emissionDate);
				rBill.setName(document.name);
				documentRepository.save(rBill);
				result.Status ="OK";
			}
			if(document.document_type.equals("PO")) {
				PurchaseOrder po = new PurchaseOrder();
				po.setAddress(document.address);
				po.setEmissionDate(document.emissionDate);
				po.setName(document.name);
				documentRepository.save(po);
				result.Status ="OK";
			}
		} catch (Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}
		
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResultDTO> getDocumentById(@PathVariable Long id){
		ResultDTO result = new ResultDTO();
		Optional<BullsEyeDocument> document = documentRepository.findById(id);
		
		try {
			if(document != null) {
				result.Data = document;
				result.Status = "OK";
			}
		} catch (Exception ex) {
			result.Status="EX";
			result.Data= document;
		}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResultDTO> updateDocument(@PathVariable Long id, @RequestBody BullsEyeDocumentDTO document){
		ResultDTO result = new ResultDTO();
		
	//Search document based on the id.
		BullsEyeDocument doc = documentRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("document not found with id: " + id));
		
		//assign values to our DTO
		result.Data = doc;
		try {
			if(doc != null) {
				//update document
				result.Status = "OK";
				doc.setName(document.name);
				doc.setAddress(document.address);
				doc.setEmissionDate(document.emissionDate);
			}
		} catch (Exception ex) {
			result.Status = "EX";
			result.Error = ex;
		}
		
		return ResponseEntity.ok(result);
	}
}
