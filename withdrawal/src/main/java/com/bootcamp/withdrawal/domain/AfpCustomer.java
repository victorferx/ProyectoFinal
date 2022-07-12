package com.bootcamp.withdrawal.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfpCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=8)
	@NotNull
	@NotBlank
	private String identityCard;
	
	@DecimalMin("0.00")
	private BigDecimal amount;
	
	private Timestamp depositDate;
	
	@NotNull
	private String bankAccount;
	
	@JoinColumn(name = "afp_id")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Afp afp;
	
}
