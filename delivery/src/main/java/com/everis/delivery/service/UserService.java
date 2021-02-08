package com.everis.delivery.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.delivery.exceptions.UserNotFoundException;
import com.everis.delivery.model.User;
import com.everis.delivery.repository.UserRepository;
import com.everis.delivery.exceptions.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public List<User> list() {
		return userRepository.findAll();
	}

	public User create(User user) {
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
