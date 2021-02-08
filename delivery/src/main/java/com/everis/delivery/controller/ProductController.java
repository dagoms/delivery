package com.everis.delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.model.Product;
import com.everis.delivery.service.ProductService;
import com.everis.delivery.form.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public List<Product> list() {

		return productService.list();
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

//	Tentativa de metodo para atualizar o produto, precisa ser refeito	
//	Está criando um novo produto ao invés de atualizar o mesmo
//	@PutMapping("/{id}")
//	public Product update(@RequestBody Product product) {
//		return product.update(product);
//	} 

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
}