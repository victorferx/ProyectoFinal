package com.bootcamp.withdrawal.web.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestWithdrawalModel {
	@JsonProperty("requestWithdrawalId")
	private Long id;
	
	private String identityCard;
	
	private BigDecimal amount;
	
	private Long afpId;
}
