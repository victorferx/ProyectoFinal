package com.bootcamp.withdrawal.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.bootcamp.withdrawal.domain.AfpCustomer;
import com.bootcamp.withdrawal.web.model.AfpCustomerModel;

@Mapper(componentModel = "spring")
public interface AfpCustomerMapper {
	AfpCustomer afpCustomerModelToAfpCustomer(AfpCustomerModel model);
	AfpCustomerModel afpCustomerToAfpCustomerModel(AfpCustomer domain);
	List<AfpCustomerModel> afpCustomersToAfpCustomerModels(List<AfpCustomer> domain);
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget AfpCustomer entity, AfpCustomerModel updateEntity);
}
