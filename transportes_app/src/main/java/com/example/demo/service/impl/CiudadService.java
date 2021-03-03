package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ciudad;
import com.example.demo.repository.CiudadRepository;
import com.example.demo.service.ICiudadService;

@Service
public class CiudadService implements ICiudadService{

	@Autowired
	CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> listCiudades() {
		
		List<Ciudad> lista = ciudadRepository.findAll();
		
		return lista;
	}
	
	

}
