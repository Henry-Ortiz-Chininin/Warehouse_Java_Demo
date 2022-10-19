package com.alphacoders.backend.documentmanagement.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.documentmanagement.dto.BullsEyeDocumentDTO;
import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.BullsEyeDocument;
import com.alphacoders.backend.model.Invoice;
import com.alphacoders.backend.model.PurchaseOrder;
import com.alphacoders.backend.model.ReturningBill;
import com.alphacoders.backend.model.Waybill;
import com.alphacoders.backend.repository.DocumentRepository;

/**
 * @author Alphacoders.
 * @version v1.0
 * 
 * DocumentDomainService contains the business logic of the BullsEyeDocument
 * object type implements IWarehouseManagement.
 *
 */
@Service
public class DocumentDomainService implements IDocumentManagement{

	@Autowired
	private DocumentRepository documentRepository;
	
	public DocumentDomainService() {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BullsEyeDocument> findAll() {
		return documentRepository.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BullsEyeDocumentDTO createDocument(BullsEyeDocumentDTO document) {
		List<BullsEyeDocument> documents = documentRepository.findAll();
		documents = documents.stream().filter(d->Objects.equals(d.getName(), document.name))
				.collect(Collectors.toList());
		
		if(!documents.isEmpty()) {
			throw new DocumentNameAlreadyExistsException(document.name);
		}
		if(document.type.equals("I")) {
			Invoice invoice = new Invoice();
			invoice.setAddress(document.address);
			invoice.setEmissionDate(document.emissionDate);
			invoice.setName(document.name);
			documentRepository.save(invoice);
		}
		if(document.type.equals("W")) {
			Waybill waybill = new Waybill();
			waybill.setAddress(document.address);
			waybill.setEmissionDate(document.emissionDate);
			waybill.setName(document.name);
			documentRepository.save(waybill);
		}
		if(document.type.equals("R")) {
			ReturningBill rBill = new ReturningBill();
			rBill.setAddress(document.address);
			rBill.setEmissionDate(document.emissionDate);
			rBill.setName(document.name);
			documentRepository.save(rBill);
		}
		if(document.type.equals("PO")) {
			PurchaseOrder po = new PurchaseOrder();
			po.setAddress(document.address);
			po.setEmissionDate(document.emissionDate);
			po.setName(document.name);
			documentRepository.save(po);
		}
		
		return document;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BullsEyeDocumentDTO updateDocument(Long id, BullsEyeDocumentDTO document) {
		BullsEyeDocument doc = documentRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("not found"));
		
		if(doc == null) {
			throw new DocumentNotExistException(document.name  + "not found");
		} else {
			doc.setAddress(document.address);
			doc.setEmissionDate(document.emissionDate);
			doc.setName(document.name);
			documentRepository.save(doc);
		}
		return document;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BullsEyeDocumentDTO getDocumentByID(Long id) {
		BullsEyeDocument document = documentRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("not found"));
		
		BullsEyeDocumentDTO documentFound = new BullsEyeDocumentDTO();
		
		documentFound.ID = document.getId();
		documentFound.address = document.getAddress();
		documentFound.emissionDate = document.getEmissionDate();
		documentFound.name = document.getName();
		documentFound.type = document.getType();
		
		return documentFound;
	}

}
