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

import com.everis.delivery.model.*;
import com.everis.delivery.repository.UserRepository;
import com.everis.delivery.service.UserService;


@RestController
@RequestMapping("/clients")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> lista() {

		return userService.list();
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping(value="/edit/{id}")
	public User update(@PathVariable Long id, @RequestBody @Valid User user) {
		Optional<User> optional = userRepository.findById(user.getId());
		return userService.save(user);
	} 

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
