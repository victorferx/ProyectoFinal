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

import com.bootcamp.withdrawal.service.IAfpCustomerService;
import com.bootcamp.withdrawal.web.model.AfpCustomerModel;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/afpcustomer")
@Slf4j
public class AfpCustomerController {

	private final IAfpCustomerService afpCustomerService;
	/**
	 * Get list customer for AFP
	 * @return
	 * @throws Exception
	 */
	@GetMapping()
	@Operation(summary = "Get all list of customer for AFP.")
	public ResponseEntity<Object> getAll() throws Exception {
		List<AfpCustomerModel> response = afpCustomerService.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
	/**
	 * Get customer for AFP by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Get customer for AFP by id.")
	public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception {
		AfpCustomerModel response = afpCustomerService.findById(id);
		log.info("FINDBYID : " + id.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Get customer for AFP by identity card
	 * @param identityCard
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path= {"/identityCard/{identityCard}"}, produces = {"application/json"})
	@Operation(summary = "Get customer for AFP by identity card.")
	public ResponseEntity<Object> getByIdentityCard(@PathVariable("identityCard") String identityCard) throws Exception {
		AfpCustomerModel response = afpCustomerService.findByIdentityCard(identityCard);
		log.info("FINDBYDNI : " + identityCard);
		log.debug("FINDBYDNI ->" + response.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	
	/**
	 * Create customer for AFP
	 * @param afpCustomerModel
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	@Operation(summary = "Create a customer for AFP.")
	public ResponseEntity<Object>  create(@Valid @RequestBody AfpCustomerModel afpCustomerModel) throws Exception {
		AfpCustomerModel response = afpCustomerService.create(afpCustomerModel);
		log.debug("CREATE : " + afpCustomerModel.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Update customer for AFP by id
	 * @param id
	 * @param afpCustomerModel
	 * @throws Exception
	 */
	@PutMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Update customer for AFP by id.")
	public void update(@PathVariable("id") Long id, @RequestBody AfpCustomerModel afpCustomerModel) throws Exception {
		afpCustomerService.update(id, afpCustomerModel);
		log.debug("UPDATE : " + afpCustomerModel.toString());
		log.info("UPDATE id=" + id.toString());
	}

	/**
	 * Delete customer for AFP by id
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Delete customer for AFP by id.")
	public void deleteById(@PathVariable("id") Long id) throws Exception {
		afpCustomerService.deleteById(id);
		log.info("DELETE id=" + id.toString());
	}
}
