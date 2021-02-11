package com.everis.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.delivery.repository.ProductRepository;
import com.everis.delivery.exceptions.ProductNotFoundException;
import com.everis.delivery.model.*;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> list() {
		return productRepository.findAll();
	}

	public Product findById(Long id) throws ProductNotFoundException {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(String.format("Produto nao encontrado ", id)));
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public ResponseEntity<?> delete(Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
//	Tentativa de metodo para atualizar o produto, precisa ser refeito	
//	Está criando um novo produto ao invés de atualizar o mesmo
//	public Product update (Long id, ProductRepository ProductRepository) {
//		Product product = ProductRepository.getOne(id);
//		
//		product.setDescription(this.description);
//		product.setPrice(this.price);
//		
//		
//		return product;
//	}

}
