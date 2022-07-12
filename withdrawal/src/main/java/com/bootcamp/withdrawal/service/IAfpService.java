package com.bootcamp.withdrawal.service;

import java.util.List;

import com.bootcamp.withdrawal.web.model.AfpModel;

public interface IAfpService {
	List<AfpModel> findAll() throws Exception;
	AfpModel findById(Long id) throws Exception;
	AfpModel create(AfpModel afpModel) throws Exception;
	void update(Long id, AfpModel afpModel) throws Exception;
	void deleteById(Long id) throws Exception;
}
