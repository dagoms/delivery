package com.everis.delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.model.*;
import com.everis.delivery.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<User> lista() {

		return userService.list();
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
