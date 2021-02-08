package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.delivery.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
