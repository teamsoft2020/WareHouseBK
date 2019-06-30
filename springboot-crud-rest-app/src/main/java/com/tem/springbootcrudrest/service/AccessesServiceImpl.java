package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Accesses;
import com.tem.springbootcrudrest.repository.AccessesRepository;

@Component
public class AccessesServiceImpl implements AccessesService{

	@Autowired
	AccessesRepository accessesRepository;
	
	@Override
	public Accesses createAccesses(Accesses accesses) {
		
		return accessesRepository.save(accesses);
		
	}

	@Override
	public Accesses updateAccesses(Accesses accesses) {
		
		return accessesRepository.save(accesses);
		
	}

	@Override
	public String deleteById(long accessesId) {
		accessesRepository.deleteById(accessesId);
		return "Deleted Accesses Successfully";
	}

	@Override
	public List<Accesses> getAccessesList() {
		
		return accessesRepository.findAll();
	}

}
