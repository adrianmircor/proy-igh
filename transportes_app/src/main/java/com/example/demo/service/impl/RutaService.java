package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ruta;
import com.example.demo.repository.RutaRepository;
import com.example.demo.service.IRutaService;

@Service
public class RutaService implements IRutaService{
	
	@Autowired
	RutaRepository rutaRepository;

	@Override
	public void guardarRuta(Ruta ruta) {
		rutaRepository.save(ruta);
		
	}

	@Override
	public void eliminarRuta(Integer idRuta) {
		rutaRepository.deleteById(idRuta);
		
	}

	@Override
	public List<Ruta> listaRutas() {
		List<Ruta> listRuta = rutaRepository.findAll();
		return listRuta;
	}

	@Override
	public Ruta buscarRuta(Integer idRuta) {

		Optional<Ruta> optionalRuta = rutaRepository.findById(idRuta);
		
		if(optionalRuta.isPresent()) {
			return optionalRuta.get();
		}
		
		return null;
	}

}
