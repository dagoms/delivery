package com.everis.delivery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.model.Product;
import com.everis.delivery.repository.ProductRepository;
import com.everis.delivery.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> list() {

		return productService.list();
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping(value="/edit/{id}")
	public Product update(@PathVariable Long id, @RequestBody @Valid Product product) {
		Optional<Product> optional = productRepository.findById(product.getId());
		return productService.save(product);
	} 

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
}