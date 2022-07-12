package com.bootcamp.withdrawal.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.bootcamp.withdrawal.domain.Afp;
import com.bootcamp.withdrawal.web.model.AfpModel;

@Mapper(componentModel = "spring")
public interface AfpMapper {
	Afp afpModelToAfp(AfpModel model);
	AfpModel afpToAfpModel(Afp domain);
	List<AfpModel> afpsToAfpModels(List<Afp> domain);
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget Afp entity, AfpModel updateEntity);
}
