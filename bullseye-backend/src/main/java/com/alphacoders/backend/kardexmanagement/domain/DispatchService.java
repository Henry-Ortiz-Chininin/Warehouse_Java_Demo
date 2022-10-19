package com.alphacoders.backend.kardexmanagement.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.kardexmanagement.dto.DispatchClientDTO;
import com.alphacoders.backend.kardexmanagement.dto.DispatchDTO;
import com.alphacoders.backend.kardexmanagement.dto.DispatchVirtualDTO;
import com.alphacoders.backend.kardexmanagement.dto.DispatchWarehouseDTO;
import com.alphacoders.backend.kardexmanagement.dto.ProductDTO;
import com.alphacoders.backend.kardexmanagement.dto.ReceptionDTO;
import com.alphacoders.backend.kardexmanagement.dto.WarehouseDTO;
import com.alphacoders.backend.model.Kardex;
import com.alphacoders.backend.model.KardexDetail;
import com.alphacoders.backend.model.StockProduct;
import com.alphacoders.backend.model.Warehouse;
import com.alphacoders.backend.repository.IKardexDetailRepository;
import com.alphacoders.backend.repository.IKardexRepository;
import com.alphacoders.backend.repository.IStockProductRepository;
import com.alphacoders.backend.repository.WarehouseRepository;

@Service
public class DispatchService implements IDispatchService {

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
	public DispatchService() {
		// TODO Auto-generated constructor stub
	}

	public DispatchDTO getNewDispatch() {
		DispatchDTO result= new DispatchDTO();
		
		result.Warehouses = new ArrayList<WarehouseDTO>(); 
		result.Products = new ArrayList<ProductDTO>(); 
		
		whrepository.findAll().forEach(store -> result.Warehouses.add(new WarehouseDTO(store.getId(), store.toString(),store.getType(), false)));
				
		return result;
	}
	

	public Long addDispatchToWarehouse(DispatchWarehouseDTO data) {

		//REGISTER OUTPUT FROM WHAREHOUSE
		Kardex newKardexOut = new Kardex(data.OperationDate, data.ToWarehouseID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "OUT");
		repository.save(newKardexOut);
		//create details
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexOut.getId(), prod.Quantity, "OUT", prod.ProductID, prod.TotalPrice)));
		
		
		//REGISTER INPUT TO VIRTUAL
		
		Kardex newKardexIn = new Kardex(data.OperationDate, data.ToWarehouseID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "IN");		
		repository.save(newKardexIn);
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexIn.getId(), prod.Quantity, "IN", prod.ProductID, prod.TotalPrice)));

		
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
	
	public Long addDispatchToVirtual(DispatchVirtualDTO data) {
		
		//REGISTER OUTPUT FROM WHAREHOUSE
		Kardex newKardexOut = new Kardex(data.OperationDate, data.ToVirtualStoreID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "OUT");
		repository.save(newKardexOut);
		//create details
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexOut.getId(), prod.Quantity, "OUT", prod.ProductID, prod.TotalPrice)));
		
		
		//REGISTER INPUT TO VIRTUAL
		
		Kardex newKardexIn = new Kardex(data.OperationDate, data.ToVirtualStoreID, data.FromWarehouseID, data.WaybillNumber,
				"", "", data.RequestNumber, "", "IN");		
		repository.save(newKardexIn);
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardexIn.getId(), prod.Quantity, "IN", prod.ProductID, prod.TotalPrice)));

		
		//update the stocks OUT
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.FromWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});

		//update the stocks IN
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.ToVirtualStoreID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});
		return newKardexOut.getId();
	}
	
	

	public Long addDispatchToClient(DispatchClientDTO data) {

		Kardex newKardex = new Kardex(data.OperationDate, null, data.FromWarehouseID, "",
				data.InvoiceNumber, data.InvoiceNumber, "", data.ClientName, "OUT");
		
		//create kardex
		repository.save(newKardex);
		//create details
		data.Products.forEach(prod->repositoryDetail.save(new KardexDetail(newKardex.getId(), prod.Quantity, "OUT", prod.ProductID, prod.TotalPrice)));

		//update the stocks
		data.Products.forEach((ProductDTO p)->{
			StockDomain stock = stockService.getProductStockByWarehouse(data.FromWarehouseID, p.ProductID);
			StockProduct model = stock.getModel();
			
			stockRepo.save(model);
		});
		
		return newKardex.getId();
	}

	
	
}
