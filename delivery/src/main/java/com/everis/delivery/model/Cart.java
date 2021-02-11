package com.everis.delivery.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cart_totalPrice")
	private double total;

	@Column(name = "cart_createdAt")
	private LocalDateTime createdAt;

//	@NotNull
//	@Enumerated(EnumType.STRING)
//	private CartStatus status;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User client;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST)
	private List<Market> items;

}
