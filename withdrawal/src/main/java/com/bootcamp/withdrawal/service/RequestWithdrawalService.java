package com.bootcamp.withdrawal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.withdrawal.domain.RequestWithdrawal;
import com.bootcamp.withdrawal.repository.RequestWithdrawalRepository;
import com.bootcamp.withdrawal.service.mapper.RequestWithdrawalMapper;
import com.bootcamp.withdrawal.web.model.RequestWithdrawalModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestWithdrawalService implements IRequestWithdrawalService {

	private final RequestWithdrawalRepository requestWithdrawalRepository;
	private final RequestWithdrawalMapper requestWithdrawalMapper;
	
	@Override
	public List<RequestWithdrawalModel> findAll() throws Exception {
		List<RequestWithdrawal> requestWithdrawals = requestWithdrawalRepository.findAll();
		return requestWithdrawalMapper.requestWithdrawalsToRequestWithdrawalModels(requestWithdrawals);
	}
	
	@Override
	public RequestWithdrawalModel findById(Long id) throws Exception {
		Optional<RequestWithdrawal> requestWithdrawal = requestWithdrawalRepository.findById(id);
		if(requestWithdrawal.isEmpty())
			throw new Exception("No existe la solicitud de retiro con el id " + id.toString());
		else
			return requestWithdrawalMapper.requestWithdrawalToRequestWithdrawalModel(requestWithdrawal.get());
	}
	
	@Override
	public RequestWithdrawalModel create(RequestWithdrawalModel requestWithdrawalModel) throws Exception {
		RequestWithdrawal requestWithdrawal = requestWithdrawalRepository.save(requestWithdrawalMapper.requestWithdrawalModelToRequestWithdrawal(requestWithdrawalModel));
		return requestWithdrawalMapper.requestWithdrawalToRequestWithdrawalModel(requestWithdrawal);
	}
	
	@Override
	public void update(Long id, RequestWithdrawalModel requestWithdrawalModel) throws Exception {
		Optional<RequestWithdrawal> requestWithdrawalOptional = requestWithdrawalRepository.findById(id);
		if(requestWithdrawalOptional.isEmpty())
			throw new Exception("No existe la solicitud de retiro con el id " + id.toString());
		else
		{
			RequestWithdrawal requestWithdrawal = requestWithdrawalOptional.get();
			requestWithdrawalMapper.update(requestWithdrawal, requestWithdrawalModel);
			requestWithdrawalRepository.save(requestWithdrawal);
		}
	}
	
	@Override
	public void deleteById(Long id) throws Exception {
		requestWithdrawalRepository.deleteById(id);
	}
	
}
