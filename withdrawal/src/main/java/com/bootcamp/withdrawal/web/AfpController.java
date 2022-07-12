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

import com.bootcamp.withdrawal.service.IAfpService;
import com.bootcamp.withdrawal.web.model.AfpModel;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/afp")
@Slf4j
public class AfpController {

	private final IAfpService afpService;
	/**
	 * Get list of AFP
	 * @return 
	 * @throws Exception
	 */
	@GetMapping()
	@Operation(summary = "Get list of AFP")
	public ResponseEntity<Object> getAll() throws Exception {
		List<AfpModel> response = afpService.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Get list AFP by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Get list of AFP by id")
	public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception {
		AfpModel response = afpService.findById(id);
		log.info("FINDBYID : " + id.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Create AFP
	 * @param afpModel
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	@Operation(summary = "Create a new AFP")
	public ResponseEntity<Object> create(@Valid @RequestBody AfpModel afpModel) throws Exception {
		AfpModel response = afpService.create(afpModel);
		log.debug("CREATE : " + afpModel.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Update AfP by id
	 * @param id
	 * @param afpModel
	 * @throws Exception
	 */
	@PutMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Modify a AFP by id")
	public void update(@PathVariable("id") Long id, @RequestBody AfpModel afpModel) throws Exception {
		afpService.update(id, afpModel);
		log.debug("UPDATE : " + afpModel.toString());
		log.info("UPDATE id=" + id.toString());
	}
	
	/**
	 * Delete AFP by id
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping(path= {"{id}"}, produces = {"application/json"})
	@Operation(summary = "Delete a AFP by id")
	public void deleteById(@PathVariable("id") Long id) throws Exception {
		afpService.deleteById(id);
		log.info("DELETE id=" + id.toString());
	}
}
