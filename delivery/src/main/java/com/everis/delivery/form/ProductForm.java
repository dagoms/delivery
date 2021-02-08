package com.everis.delivery.form;

import com.everis.delivery.model.Product;
import com.everis.delivery.repository.ProductRepository;

import lombok.Data;

@Data
public class ProductForm {
	
	private String description;
	
	private double price;
	
	
	public Product update (Long id, ProductRepository ProductRepository) {
		Product product = ProductRepository.getOne(id);
		
		product.setDescription(this.description);
		product.setPrice(this.price);
		
		
		return product;
	}
}



