package com.bootcamp.withdrawal.web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfpModel {
	
	@JsonProperty("afpId")
	private Long id;
	
	@NotNull(message="Debe escribir el nombre de la AFP.")
	@NotBlank(message="Debe escribir el nombre de la AFP.")
	private String name;
	
}
