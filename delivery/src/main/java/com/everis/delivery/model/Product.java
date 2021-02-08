package com.everis.delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.everis.delivery.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private double price;

//	public Product update (Long id, ProductRepository ProductRepository) {
//		Product product = ProductRepository.getOne(id);
//		
//		product.setDescription(this.description);
//		product.price(this.price)
//		topico.setMensagem(this.mensagem);
//		
//		return topico;
//	}
}
