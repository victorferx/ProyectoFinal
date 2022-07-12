package com.bootcamp.withdrawal.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.bootcamp.withdrawal.domain.RequestWithdrawal;
import com.bootcamp.withdrawal.web.model.RequestWithdrawalModel;

@Mapper(componentModel = "spring")
public interface RequestWithdrawalMapper {

	RequestWithdrawal requestWithdrawalModelToRequestWithdrawal(RequestWithdrawalModel model);
	RequestWithdrawalModel requestWithdrawalToRequestWithdrawalModel(RequestWithdrawal domain);
	List<RequestWithdrawalModel> requestWithdrawalsToRequestWithdrawalModels(List<RequestWithdrawal> domain);
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget RequestWithdrawal entity, RequestWithdrawalModel updateEntity);
}
