package com.alphacoders.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.alphacoders.backend.model.KardexDetail;

@Repository
public interface IKardexDetailRepository extends JpaRepository<KardexDetail, Long>, QueryByExampleExecutor<KardexDetail> {

	
	
}
