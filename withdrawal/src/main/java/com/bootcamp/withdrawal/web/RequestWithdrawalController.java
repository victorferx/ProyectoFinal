package com.bootcamp.withdrawal.web;

import java.util.List;

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

import com.bootcamp.withdrawal.service.IRequestWithdrawalService;
import com.bootcamp.withdrawal.web.model.RequestWithdrawalModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/requestwithdrawal")
@Slf4j
public class RequestWithdrawalController {
	
	private final IRequestWithdrawalService requestWithdrawalService;
	
	@GetMapping()
	public ResponseEntity<Object> getAll() throws Exception {
		List<RequestWithdrawalModel> response = requestWithdrawalService.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
	@GetMapping(path= {"{id}"}, produces = {"application/json"})
	public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception {
		RequestWithdrawalModel response = requestWithdrawalService.findById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object>  create(@RequestBody RequestWithdrawalModel requestWithdrawalModel) throws Exception {
		RequestWithdrawalModel response = requestWithdrawalService.create(requestWithdrawalModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(path= {"{id}"}, produces = {"application/json"})
	public void update(@PathVariable("id") Long id, @RequestBody RequestWithdrawalModel requestWithdrawalModel) throws Exception {
		requestWithdrawalService.update(id, requestWithdrawalModel);
	}

	@DeleteMapping(path= {"{id}"}, produces = {"application/json"})
	public void deleteById(@PathVariable("id") Long id) throws Exception {
		requestWithdrawalService.deleteById(id);
	}
}
