package com.bootcamp.withdrawal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.withdrawal.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByIdentityCard(String identityCard);
}
