package com.bootcamp.withdrawal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.withdrawal.domain.AfpCustomer;
import com.bootcamp.withdrawal.repository.AfpCustomerRepository;
import com.bootcamp.withdrawal.service.mapper.AfpCustomerMapper;
import com.bootcamp.withdrawal.web.model.AfpCustomerModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AfpCustomerService implements IAfpCustomerService {

	private final AfpCustomerRepository afpCustomerRepository;
	private final AfpCustomerMapper afpCustomerMapper;
	
	@Override
	public List<AfpCustomerModel> findAll() throws Exception {
		List<AfpCustomer> afpCustomers = afpCustomerRepository.findAll();
		return afpCustomerMapper.afpCustomersToAfpCustomerModels(afpCustomers);
	}
	
	@Override
	public AfpCustomerModel findById(Long id) throws Exception {
		Optional<AfpCustomer> afpCustomer = afpCustomerRepository.findById(id);
		if (afpCustomer.isEmpty())
			throw new Exception("No existe registro de Cliente y Afp.");
		else
			return afpCustomerMapper.afpCustomerToAfpCustomerModel(afpCustomer.get());
	}
	
	@Override
	public AfpCustomerModel findByIdentityCard(String identityCard) throws Exception {
		AfpCustomer afpCustomer = afpCustomerRepository.findByIdentityCard(identityCard);
		return afpCustomerMapper.afpCustomerToAfpCustomerModel(afpCustomer);
	}
	
	@Override
	public AfpCustomerModel create(AfpCustomerModel afpCustomerModel) throws Exception {
		AfpCustomer afpCustomer = afpCustomerRepository.save(afpCustomerMapper.afpCustomerModelToAfpCustomer(afpCustomerModel));
		return afpCustomerMapper.afpCustomerToAfpCustomerModel(afpCustomer);
	}
	
	@Override
	public void update(Long id, AfpCustomerModel afpCustomerModel) throws Exception {
		Optional<AfpCustomer> afpCustomerOptional = afpCustomerRepository.findById(id);
		if (afpCustomerOptional.isEmpty())
			throw new Exception("No existe registro de Cliente y Afp con el id " + id.toString());
		else
		{
			AfpCustomer afpCustomer = afpCustomerOptional.get();
			afpCustomerMapper.update(afpCustomer, afpCustomerModel);
			afpCustomerRepository.save(afpCustomer);
		}
	}
	
	@Override
	public void deleteById(Long id) throws Exception {
		afpCustomerRepository.deleteById(id);
	}
}
