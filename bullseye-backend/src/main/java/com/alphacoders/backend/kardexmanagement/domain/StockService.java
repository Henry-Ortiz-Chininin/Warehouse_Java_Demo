package com.alphacoders.backend.kardexmanagement.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.model.Kardex;
import com.alphacoders.backend.model.KardexDetail;
import com.alphacoders.backend.repository.IKardexDetailRepository;
import com.alphacoders.backend.repository.IKardexRepository;

@Service
public class StockService implements IStockService {
	@Autowired
	private IKardexRepository kardexRepo;
	
	@Autowired
	private IKardexDetailRepository detailRepo;
	
	@Override
	public StockDomain getProductStockByWarehouse(Long WarehouseID, Long ProductID) {
		KardexDetail detail = new KardexDetail();
		detail.setProductId(ProductID.longValue());

		Kardex kardexIn = new Kardex();
		kardexIn.setWarehouseInputID(WarehouseID);

		Kardex kardexOut = new Kardex();
		kardexOut.setWarehouseOutputID(WarehouseID);

		
		StockDomain stock = new StockDomain(WarehouseID, ProductID, 0, 0);
		
		List<KardexDetail> details = detailRepo.findAll();
		List<Kardex> kardexsIn = kardexRepo.findAll(Example.of(kardexIn));
		List<Kardex> kardexsOut = kardexRepo.findAll(Example.of(kardexOut));
		
		
		for(KardexDetail d: details) {
			if(d.getProductId().longValue()==ProductID) {
				//ADDING INCOMINGS
				for(Kardex in: kardexsIn) {
					if(d.getKardexId().equals(in.getId())) {
						stock.setQuantity(stock.getQuantity()+d.getQuantity());		
						stock.setTotalPrice(stock.getTotalPrice()+d.getTotal());
					}
				}
				//REDUCING BY OUTGOINGS
				for(Kardex out: kardexsOut) {
					if(d.getKardexId().equals(out.getId())) {
						stock.setQuantity(stock.getQuantity()-d.getQuantity());
						stock.setTotalPrice(stock.getTotalPrice()-d.getTotal());
					}
				}	
			}
		}
				
				
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public StockDomain getProductStock(Long ProductID) {
		KardexDetail detail = new KardexDetail();
		detail.setProductId(ProductID);
		
		StockDomain stock = new StockDomain(null, ProductID, 0, 0);
		
		detailRepo.findAll(Example.of(detail)).forEach((KardexDetail d)->{
			//ADDING INCOMINGS
			if(d.getMovementType().equals("IN")) {
				stock.setQuantity(stock.getQuantity()+d.getQuantity());									
			}
			//REDUCING BY OUTGOINGS
			if(d.getMovementType().equals("OUT")) {
				stock.setQuantity(stock.getQuantity()-d.getQuantity());									
			}
						
		});
				
				
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public List<StockDomain> getStockByWarehouse(Long Warehouse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockDomain> getStockByProduct(Long ProductID) {
		// TODO Auto-generated method stub
		return null;
	}

	public StockService() {
		// TODO Auto-generated constructor stub
	}

}
