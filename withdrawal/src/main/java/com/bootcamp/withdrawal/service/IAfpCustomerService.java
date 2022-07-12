package com.bootcamp.withdrawal.service;

import java.util.List;

import com.bootcamp.withdrawal.web.model.AfpCustomerModel;

public interface IAfpCustomerService {
	List<AfpCustomerModel> findAll() throws Exception;
	AfpCustomerModel findById(Long id) throws Exception;
	AfpCustomerModel findByIdentityCard(String identityCard) throws Exception;
	AfpCustomerModel create(AfpCustomerModel afpCustomerModel) throws Exception;
	void update(Long id, AfpCustomerModel afpCustomerModel) throws Exception;
	void deleteById(Long id) throws Exception;
}
