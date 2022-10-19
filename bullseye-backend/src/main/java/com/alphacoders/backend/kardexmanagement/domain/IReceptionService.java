package com.alphacoders.backend.kardexmanagement.domain;

import org.springframework.data.repository.NoRepositoryBean;

import com.alphacoders.backend.kardexmanagement.dto.ReceptionDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionProviderDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionVirtualDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionWarehouseDTO;

@NoRepositoryBean
public interface IReceptionService {
	public ReceptionDTO getNewReception();
	public Long addReceiptFromWarehouse(ReceptionWarehouseDTO data);
	public Long addReceiptFromVirtual(ReceptionVirtualDTO data);
	public Long addReceiptFromProvider(ReceptionProviderDTO data);
	
}
