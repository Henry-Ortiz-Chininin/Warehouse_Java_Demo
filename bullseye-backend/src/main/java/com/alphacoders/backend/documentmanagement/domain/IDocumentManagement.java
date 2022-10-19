package com.alphacoders.backend.documentmanagement.domain;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.alphacoders.backend.documentmanagement.dto.BullsEyeDocumentDTO;
import com.alphacoders.backend.model.BullsEyeDocument;

/**
 * IDocumentManagement interface for business logic implementation.
 * 
 * @author Alphacoders
 * @version v1.0
 *
 */
@NoRepositoryBean
public interface IDocumentManagement {
	
	/**
	 * Generates a list of Warehouse objects.
	 * */
	List<BullsEyeDocument> findAll();
	
	/**
	 * Create a new warehouse object.
	 * @param BullsEyeDocumentDTO document. 
	 * @return BullsEyeDocumentDTO document.
	 * */
	BullsEyeDocumentDTO createDocument(BullsEyeDocumentDTO document);
	
	/**
	 * Update an existing warehouse object.
	 * @param Long id,
	 * @param BullsEyeDocumentDTO document.
	 * @return BullsEyeDocumentDTO document.
	 * */
	BullsEyeDocumentDTO updateDocument(Long id, BullsEyeDocumentDTO document);
	
	/**
	 * Retrieve an existing warehouse object by id.
	 * @param Long id,
	 * @param BullsEyeDocumentDTO document.
	 * @return BullsEyeDocumentDTO document.
	 * */
	BullsEyeDocumentDTO getDocumentByID(Long id);
	
}

