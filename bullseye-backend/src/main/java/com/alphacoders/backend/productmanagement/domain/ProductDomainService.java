package com.alphacoders.backend.productmanagement.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.Accessories;
import com.alphacoders.backend.model.Clothing;
import com.alphacoders.backend.model.Equipment;
import com.alphacoders.backend.model.Footwear;
import com.alphacoders.backend.model.Product;
import com.alphacoders.backend.model.Seasonal;
import com.alphacoders.backend.model.Warehouse;
import com.alphacoders.backend.model.Wellness;
import com.alphacoders.backend.productmanagement.dto.ProductDTO;
import com.alphacoders.backend.repository.*;
import com.alphacoders.backend.warehousemanagement.domain.WarehouseNameAlreadyExistsException;
import com.alphacoders.backend.warehousemanagement.dto.WarehouseDTO;

/**
 * @author Alphacoders
 * @version v1.0
 * 
 *          ProductDomainService contains the business logic of the Product
 *          object type implements IProductManagement
 *
 */

@Service
public class ProductDomainService implements IProductManagement {

	@Autowired
	private ProductRepository productRepository;

	public ProductDomainService() {
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public List<ProductDTO> findAll() {

		List<ProductDTO> products = new ArrayList<ProductDTO>();

		productRepository.findAll().forEach(prod -> products.add(new ProductDTO(prod.getId(), prod.getName(),
				prod.getDescription(), prod.getCategory(), prod.getSubCategory(), prod.getUnitPrice(), prod.getStock())));

		return products;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public ProductDTO createProduct(ProductDTO product) {

		List<Product> products = null;

		try {
			products = productRepository.findAll();
			products = products.stream().filter(e -> Objects.equals(e.getName(), product.name))
					.collect(Collectors.toList());

		} catch (Exception ex) {
			products = new ArrayList<Product>();
		}
		if (!products.isEmpty()) {
			throw new WarehouseNameAlreadyExistsException(product.name);
		}

		if (product.category.equals("ACCESSORIES")) {
			Accessories accessories = new Accessories(product.name, product.description, product.subCategory,product.category,product.unitPrice,product.stock);
			productRepository.save(accessories);

		}
		if (product.category.equals("CLOTHING")) {
			Clothing clothing = new Clothing(product.name, product.description, product.subCategory,product.category,product.unitPrice,product.stock);

			productRepository.save(clothing);

		}
		if (product.category.equals("FOOTWEAR")) {
			Footwear footwear = new Footwear(product.name, product.description, product.subCategory,product.category,product.unitPrice,product.stock);
			productRepository.save(footwear);

		}
		if (product.category.equals("SEASONAL")) {
			Seasonal seasonal = new Seasonal(product.name, product.description, product.subCategory,product.category,product.unitPrice,product.stock);
			productRepository.save(seasonal);

		}
		if (product.category.equals("WELLNESS")) {
			Wellness wellness = new Wellness(product.name, product.description, product.subCategory,product.category,product.unitPrice,product.stock);
			productRepository.save(wellness);

		}
		if (product.category.equals("EQUIPMENT")) {
			Equipment equipment = new Equipment(product.name, product.description, product.subCategory,product.category,product.unitPrice,product.stock);
			productRepository.save(equipment);

		}
		products = productRepository.findAll().stream().filter(e -> Objects.equals(e.getName(), product.name))
				.collect(Collectors.toList());

		return product;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no found"));

		if (product == null) {
			throw new ProductNotExistsException(productDetails.name + " no found");
		} else {

			product.setId(productDetails.id);
			product.setName(productDetails.name);
			product.setDescription(productDetails.description);
			product.setCategory(productDetails.category);
			product.setSubCategory(productDetails.subCategory);
			product.setUnitPrice(productDetails.unitPrice);
			product.setStock(productDetails.stock);
			productRepository.save(product);
		}

		product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no found"));
		ProductDTO updateProduct = new ProductDTO(product.getId(), product.getName(), product.getDescription(),
				product.getCategory(), product.getSubCategory(),product.getUnitPrice(), product.getStock());
		return updateProduct;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no found"));

		ProductDTO productFound = new ProductDTO();

		productFound.id = product.getId();
		productFound.name = product.getName();
		productFound.category = product.getCategory();
		productFound.description = product.getDescription();
		productFound.subCategory = product.getSubCategory();
		productFound.unitPrice = product.getUnitPrice();
		productFound.stock = product.getStock();

		return productFound;
	}

}
