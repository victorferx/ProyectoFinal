package com.bootcamp.withdrawal.web.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
	@JsonProperty("customerId")
	private Long id;
	
	@NotBlank(message="No puede ser vacio el DNI.")
	private String identityCard;
	
	@NotBlank(message="No puede ser vacio el nombre.")
	private String name;
	
	@NotBlank(message="No puede ser vacio el apellido.")
	private String lastName;
	
	@NotBlank(message="No puede ser vacio el telefono.")
	private String phoneNumber;
	
	private String email;
}
