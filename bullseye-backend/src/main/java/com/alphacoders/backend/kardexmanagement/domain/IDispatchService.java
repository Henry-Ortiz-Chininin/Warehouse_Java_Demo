package com.alphacoders.backend.kardexmanagement.domain;

import org.springframework.data.repository.NoRepositoryBean;

import com.alphacoders.backend.kardexmanagement.dto.DispatchClientDTO;
import com.alphacoders.backend.kardexmanagement.dto.DispatchDTO;
import com.alphacoders.backend.kardexmanagement.dto.DispatchVirtualDTO;
import com.alphacoders.backend.kardexmanagement.dto.DispatchWarehouseDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionDTO;

@NoRepositoryBean
public interface IDispatchService {
	public DispatchDTO getNewDispatch();
	public Long addDispatchToWarehouse(DispatchWarehouseDTO data);
	public Long addDispatchToVirtual(DispatchVirtualDTO data);
	public Long addDispatchToClient(DispatchClientDTO data);
}
