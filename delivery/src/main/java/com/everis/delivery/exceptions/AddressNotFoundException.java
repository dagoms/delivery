package com.everis.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(String message) {
		super(message);
	}

}
