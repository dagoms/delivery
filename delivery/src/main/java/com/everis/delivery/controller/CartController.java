package com.everis.delivery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.service.CartService;
import com.everis.delivery.dto.CartDto;
import com.everis.delivery.exceptions.UserNotFoundException;
import com.everis.delivery.model.*;


@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	

	@GetMapping
	public List<Cart> list() {
		return cartService.list();
	}

	@PostMapping
	public Cart create(@RequestBody CartDto dto) throws UserNotFoundException {
		return cartService.save(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		cartService.delete(id);
	}

}
