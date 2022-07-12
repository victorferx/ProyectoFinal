package com.bootcamp.withdrawal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.withdrawal.domain.Afp;
import com.bootcamp.withdrawal.repository.AfpRepository;
import com.bootcamp.withdrawal.service.mapper.AfpMapper;
import com.bootcamp.withdrawal.web.model.AfpModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AfpService implements IAfpService {
	private final AfpRepository afpRepository;
	private final AfpMapper afpMapper;
	
	@Override
	public List<AfpModel> findAll() throws Exception {
		List<Afp> afps = afpRepository.findAll();
		return afpMapper.afpsToAfpModels(afps);
	}
	
	@Override
	public AfpModel findById(Long id) throws Exception {
		Optional<Afp> afp = afpRepository.findById(id);
		if (afp.isEmpty())
			throw new Exception("No existe el Afp con id " + id.toString());
		else
			return afpMapper.afpToAfpModel(afp.get());
	}
	
	@Override
	public AfpModel create(AfpModel afpModel) throws Exception {
		Afp afp = afpRepository.save(afpMapper.afpModelToAfp(afpModel));
		return afpMapper.afpToAfpModel(afp);
	}
	
	@Override
	public void update(Long id, AfpModel afpModel) throws Exception {
		Optional<Afp> afpOptional = afpRepository.findById(id);
		if (afpOptional.isEmpty())
			throw new Exception("No existe el Afp con id " + id.toString());
		else
		{
			Afp afp = afpOptional.get();
			afpMapper.update(afp, afpModel);
			afpRepository.save(afp);
		}
	}
	
	@Override
	public void deleteById(Long id) throws Exception {
		afpRepository.deleteById(id);
	}
}
