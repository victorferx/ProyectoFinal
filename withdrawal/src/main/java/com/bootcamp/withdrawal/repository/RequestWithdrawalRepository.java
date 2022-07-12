package com.bootcamp.withdrawal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.withdrawal.domain.RequestWithdrawal;

public interface RequestWithdrawalRepository extends JpaRepository<RequestWithdrawal, Long> {

}
