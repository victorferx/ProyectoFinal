package com.bootcamp.withdrawal.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfpCustomerModel {
	@JsonProperty("afpCustomerId")
	private Long id;
	
	@NotNull(message="Debe registrar un DNI.")
	@NotBlank(message="El DNI no puede ser vacio.")
	private String identityCard;
	
	@DecimalMin("0.00")
	private BigDecimal amount;
	
	@JsonProperty("date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Timestamp depositDate;
	
	@NotBlank(message="La cuenta no debe ser vacia.")
	private String bankAccount;

	private AfpModel afp;
}
