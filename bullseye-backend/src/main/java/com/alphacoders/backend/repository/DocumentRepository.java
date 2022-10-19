package com.alphacoders.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphacoders.backend.model.BullsEyeDocument;

public interface DocumentRepository extends JpaRepository<BullsEyeDocument, Long> {

}
