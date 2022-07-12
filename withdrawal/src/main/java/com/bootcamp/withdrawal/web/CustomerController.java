package com.bootcamp.withdrawal.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.withdrawal.service.ICustomerService;
import com.bootcamp.withdrawal.web.model.CustomerModel;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customer")
@Slf4j
public class CustomerController {
	
	private final ICustomerService customerService;
	
	/**
	 * Get list of customer
	 * @return
	 * @throws Exception
	 */
	@GetMapping()
	@Operation(summary = "Get all customer.")
	public ResponseEntity<Object> getAll() throws Exception {
		List<CustomerModel> response = customerService.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
	/**
	 * Get customer for id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Get customer by id.")
	public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception {
		CustomerModel response = customerService.findById(id);
		log.info("FINDBYID : " + id.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Get customer for identity card
	 * @param identityCard
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path= {"/identityCard/{identityCard}"}, produces = {"application/json"})
	@Operation(summary = "Get customer by idntity card.")
	public ResponseEntity<Object> getByIdentityCard(@PathVariable("identityCard") String identityCard) throws Exception {
		CustomerModel response = customerService.findByIdentityCard(identityCard);
		log.info("FINDBYDNI : " + identityCard);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	
	/**
	 * Create customer
	 * @param customerModel
	 * @throws Exception
	 */
	@PostMapping
	@Operation(summary = "Create a customer.")
	public void create(@Valid @RequestBody CustomerModel customerModel) throws Exception {
		customerService.create(customerModel);
		log.debug("CREATE : " + customerModel.toString());
	}
	
	/**
	 * Update customer for id
	 * @param id
	 * @param customerModel
	 * @throws Exception
	 */
	@PutMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Update customer by id.")
	public void update(@PathVariable("id") Long id, @Valid @RequestBody CustomerModel customerModel) throws Exception {
		customerService.update(id, customerModel);
		log.debug("UPDATE : " + customerModel.toString());
		log.info("UPDATE id=" + id.toString());
	}

	/**
	 * Delete customer for id
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Delete customer by id.")
	public void deleteById(@PathVariable("id") Long id) throws Exception {
		customerService.deleteById(id);
		log.info("DELETE id=" + id.toString());
	}
}
