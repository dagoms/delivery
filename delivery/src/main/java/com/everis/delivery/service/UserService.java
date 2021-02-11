package com.everis.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.delivery.exceptions.UserNotFoundException;
import com.everis.delivery.model.User;
import com.everis.delivery.repository.UserRepository;
import com.everis.delivery.exceptions.*;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> list() {
		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public ResponseEntity<?> delete(Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	public User findById(Long id) throws UserNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Cliente nao encontrado, favor realizar o cadastro."));
	}
}
