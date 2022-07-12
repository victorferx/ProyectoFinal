package com.bootcamp.withdrawal.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.bootcamp.withdrawal.domain.Customer;
import com.bootcamp.withdrawal.web.model.CustomerModel;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	Customer customerModelToCustomer(CustomerModel model);
	CustomerModel customerToCustomerModel(Customer domain);
	List<CustomerModel> customersToCustomerModels(List<Customer> domain);
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget Customer entity, CustomerModel updateEntity);
}
