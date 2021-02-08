package com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.server.Ssl.ClientAuth;

import com.everis.delivery.model.Address;
import com.everis.delivery.model.PaymentMethod;
import com.everis.delivery.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private Long id;
	private String nome;
	private String email;
	private PaymentMethod payment;
	private Address address;

}