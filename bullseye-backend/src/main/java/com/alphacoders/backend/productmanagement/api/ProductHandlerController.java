package com.alphacoders.backend.productmanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.model.Product;
import com.alphacoders.backend.productmanagement.domain.IProductManagement;
import com.alphacoders.backend.productmanagement.dto.ProductDTO;

/**
 * @author Alphacoders
 * @version v1.0
 * 
 * ProducteHandler Controller is the class in charge of generating the 
 * REST API methods for interaction with the front-end.
 *
 */


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/producthandler")
public class ProductHandlerController {

	@Autowired
	private IProductManagement repository;

	
	/**
	 * getAllProducts GET request method to retrieve a list of
	 * object ProductDTO from the database.
	 * 
	 * */
	
	@GetMapping("products")
	public List<ProductDTO> getAllProducts() {
		return repository.findAll();
	}

	
	/**
	 * Newproduct POST request method to generate a new Product data entry to the backend.
	 * @param ProductDTO product,
	 * @return ResultDTO a ResultDTO result with status message.  
	 */
	
	@PostMapping("newproduct")
	public ResultDTO addUser(@RequestBody ProductDTO product) {
		ResultDTO result = new ResultDTO();

		try {
			result.Data = repository.createProduct(product);
			result.Status = "OK";
		} catch (Exception ex) {
			result.Status = "EX";
			result.Error = ex;
		}
		return result;

	}
	
	/**
	 * updateProduct PUT request  method to UPDATE a data entry of the product class already existing
	 * in the database.
	 * @param Long id,
	 * @param ProductDTO product,
	 * @return returns a ResultDTO result with status message.  
	 */

	@PutMapping("/products/{id}")
	public ResultDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDetails) {
		ResultDTO result = new ResultDTO();

		try {
			result.Data = repository.updateProduct(id, productDetails);
			result.Status = "OK";

		} catch (Exception ex) {
			result.Status = "EX";
			result.Error = ex;
		}

		return result;

	}

	
	/**
	 * getProductById GET  method to retrieve an instance of a product object
	 * based on the id.
	 * @param Long id,
	 * @return returns a ResultDTO result with status message.  
	 */
	
	@GetMapping("/products/{id}")
	public ResultDTO getProductById(@PathVariable Long id) {
		ResultDTO result = new ResultDTO();

		try {
			result.Data = repository.getProductById(id);
			result.Status = "OK";

		} catch (Exception ex) {
			result.Status = "EX";
			result.Error = ex;
		}

		return result;

	}

}
