package com.bootcamp.withdrawal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.withdrawal.domain.AfpCustomer;

public interface AfpCustomerRepository extends JpaRepository<AfpCustomer, Long>{
	AfpCustomer findByIdentityCard(String identityCard);
}
