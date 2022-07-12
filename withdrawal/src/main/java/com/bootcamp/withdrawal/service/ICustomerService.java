package com.bootcamp.withdrawal.service;

import java.util.List;

import com.bootcamp.withdrawal.web.model.CustomerModel;

public interface ICustomerService {

	List<CustomerModel> findAll() throws Exception;
	CustomerModel findById(Long id) throws Exception;
	CustomerModel findByIdentityCard(String identityCard) throws Exception;
	void create(CustomerModel customerModel) throws Exception;
	void update(Long id, CustomerModel customerModel) throws Exception;
	void deleteById(Long id) throws Exception;
}
