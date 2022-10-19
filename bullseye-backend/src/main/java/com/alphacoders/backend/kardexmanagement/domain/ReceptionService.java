package com.alphacoders.backend.kardexmanagement.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.kardexmanagement.dto.DispatchDTO;
import com.alphacoders.backend.kardexmanagement.dto.ProductDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionProviderDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionVirtualDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionWarehouseDTO;
import com.alphacoders.backend.kardexmanagement.dto.WarehouseDTO;
import com.alphacoders.backend.repository.*;
import com.alphacoders.backend.model.*;

@Service
public class ReceptionService implements IReceptionService {

	@Autowired
	WarehouseRepository whrepository;
	
	@Autowired
	private IKardexRepository repository;
	
	@Autowired
	private IKardexDetailRepository repositoryDetail;
	
	@Autowired
	private IStockProductRepository stockRepo;
	
	
	@Autowired
	private IStockService stockService;
	
	
	public ReceptionService() {
		// TODO Auto-generated constructor stub
	}

	public ReceptionDTO getNewReception() {
		ReceptionDTO result= new ReceptionDTO();
		result.Warehouses = new ArrayList<WarehouseDTO>(); 
		result.Products = new ArrayList<ProductDTO>(); 
		
		whrepository.findAll().forEach(store -> result.Warehouses.add(new WarehouseDTO(store.getId(), store.toString(),store.getType(), false)));
		
		
		return result;
	}


	public Long addReceiptFromWarehouse(ReceptionWarehouseDTO data) {

		//REGISTER INPUT FROM WHAREHOUSE
		Kardex newKardexOut = new Kardex(data.OperationDate, data.ToWarehouseID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "IN");
		repository.save(newKardexOut);
		//create details
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexOut.getId(), prod.Quantity, "IN", prod.ProductID, prod.TotalPrice)));
		
		
		//REGISTER INPUT TO VIRTUAL
		
		Kardex newKardexIn = new Kardex(data.OperationDate, data.ToWarehouseID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "OUT");		
		repository.save(newKardexIn);
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexIn.getId(), prod.Quantity, "OUT", prod.ProductID, prod.TotalPrice)));

		
		//update the stocks OUT
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.FromWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});

		//update the stocks IN
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.ToWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});
		return newKardexOut.getId();
	}
	
	
	public Long addReceiptFromVirtual(ReceptionVirtualDTO data) {
		
		//REGISTER INPUT TO WHAREHOUSE
		Kardex newKardexOut = new Kardex(data.OperationDate, data.ToWarehouseID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "IN");
		repository.save(newKardexOut);
		//create details
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexOut.getId(), prod.Quantity, "IN", prod.ProductID, prod.TotalPrice)));
		
		
		//REGISTER OUTPUT FROM VIRTUAL
		
		Kardex newKardexIn = new Kardex(data.OperationDate, data.ToWarehouseID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "OUT");		
		repository.save(newKardexIn);
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexIn.getId(), prod.Quantity, "OUT", prod.ProductID, prod.TotalPrice)));

		
		//update the stocks OUT
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.FromWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});

		//update the stocks IN
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.ToWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});
		return newKardexOut.getId();
	}

	public Long addReceiptFromProvider(ReceptionProviderDTO data) {

		Kardex newKardex = new Kardex(data.OperationDate, data.ToWarehouseID, null, data.WaybillNumber,
				"", "", "", "", "IN");
		
		//create kardex
		repository.save(newKardex);
		//create details
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardex.getId(), prod.Quantity, "IN", prod.ProductID, prod.TotalPrice)));

		//update the stocks
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.ToWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});
		
		return newKardex.getId();
	}
}
