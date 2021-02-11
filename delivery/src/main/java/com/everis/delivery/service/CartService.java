package com.everis.delivery.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.delivery.dto.CartDto;
import com.everis.delivery.exceptions.UserNotFoundException;
import com.everis.delivery.model.Cart;
import com.everis.delivery.model.Market;
import com.everis.delivery.model.Product;
import com.everis.delivery.model.User;
import com.everis.delivery.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	public List<Cart> list() {
		return cartRepository.findAll();
	}

	public Cart save(CartDto dto) throws UserNotFoundException {
		User user = userService.findById(dto.getUserId());

		Cart cart = Cart.builder().client(user).createdAt(LocalDateTime.now()).build();

		List<Market> items = dto.getProducts().stream().map(item -> {
			try {
				Product product = productService.findById(item.getProductId());
				return Market.builder().cart(cart).product(product.getDescription()).price(product.getPrice())
						.quantity(item.getQuantity()).build();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());

		double total = 0.0;
		for (Market market : items) {
			total += market.getPrice() * market.getQuantity();
			cart.setTotal(total);
			cart.setItems(items);
		}

		return cartRepository.save(cart);
	}

	public ResponseEntity<?> delete(Long id) {
		cartRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
