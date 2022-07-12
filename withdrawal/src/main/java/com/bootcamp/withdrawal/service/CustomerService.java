package com.bootcamp.withdrawal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.withdrawal.domain.Customer;
import com.bootcamp.withdrawal.repository.CustomerRepository;
import com.bootcamp.withdrawal.service.mapper.CustomerMapper;
import com.bootcamp.withdrawal.web.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	@Override
	public List<CustomerModel> findAll() throws Exception {
		List<Customer> customers = customerRepository.findAll();
		return customerMapper.customersToCustomerModels(customers);
	}

	@Override
	public CustomerModel findById(Long id) throws Exception {
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
			return customerMapper.customerToCustomerModel(customer.get());
		else
			throw new Exception("No existe el cliente.");
	}

	@Override
	public CustomerModel findByIdentityCard(String identityCard) throws Exception {
		Customer customer = customerRepository.findByIdentityCard(identityCard);
		return customerMapper.customerToCustomerModel(customer);
	}

	@Override
	public void create(CustomerModel customerModel) throws Exception {
		customerRepository.save(customerMapper.customerModelToCustomer(customerModel));
	}

	@Override
	public void update(Long id, CustomerModel customerModel) throws Exception {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isEmpty())
			throw new Exception("No existe el cliente");
		else
		{
			Customer customerToUpdate = customerOptional.get();
			customerMapper.update(customerToUpdate, customerModel);
			customerRepository.save(customerToUpdate);
		}
	}

	@Override
	public void deleteById(Long id) throws Exception {
		customerRepository.deleteById(id);
	}

}
