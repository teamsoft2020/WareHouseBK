package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.Accesses;

@Service
public interface AccessesService {

	public Accesses createAccesses(Accesses accesses);

	public Accesses updateAccesses(Accesses accesses);

	public String deleteById(long accessesId);

	public List<Accesses> getAccessesList();
}
