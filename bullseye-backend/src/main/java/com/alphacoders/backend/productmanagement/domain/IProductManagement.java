package com.alphacoders.backend.productmanagement.domain;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.alphacoders.backend.model.Product;
import com.alphacoders.backend.productmanagement.dto.*;


@NoRepositoryBean
public interface IProductManagement {
	
	List<ProductDTO>findAll();
	ProductDTO createProduct(ProductDTO product);
	ProductDTO updateProduct(Long id ,ProductDTO product);
	ProductDTO getProductById(Long id );
}
