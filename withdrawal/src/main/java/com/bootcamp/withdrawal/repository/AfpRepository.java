package com.bootcamp.withdrawal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.withdrawal.domain.Afp;

public interface AfpRepository extends JpaRepository<Afp, Long> {
	
}
