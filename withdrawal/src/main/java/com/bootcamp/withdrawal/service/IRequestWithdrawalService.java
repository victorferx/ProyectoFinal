package com.bootcamp.withdrawal.service;

import java.util.List;

import com.bootcamp.withdrawal.web.model.RequestWithdrawalModel;

public interface IRequestWithdrawalService {
	List<RequestWithdrawalModel> findAll() throws Exception;
	RequestWithdrawalModel findById(Long id) throws Exception;
	RequestWithdrawalModel create(RequestWithdrawalModel requestWithdrawalModel) throws Exception;
	void update(Long id, RequestWithdrawalModel requestWithdrawalModel) throws Exception;
	void deleteById(Long id) throws Exception;
}
