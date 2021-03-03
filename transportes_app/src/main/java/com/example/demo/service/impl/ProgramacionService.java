package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Programacion;
import com.example.demo.repository.ProgramacionRepository;
import com.example.demo.service.IProgramacionService;

@Service
public class ProgramacionService implements IProgramacionService {

	@Autowired
	ProgramacionRepository programacionRepository;

	@Override
	public List<Programacion> listaProgramacionPorRuta(int idRuta) {

		return programacionRepository.buscarPorRuta(idRuta);
	}

	@Override
	public Programacion recuperarProgramacion(Integer idProgramacion) {
		Optional<Programacion> optionalProgram = programacionRepository.findById(idProgramacion);

		if (optionalProgram.isPresent()) {
			return optionalProgram.get();
		}

		return null;
	}

	@Override
	public void guardarProgramacion(Programacion programacion) {
		programacionRepository.save(programacion);
		
	}

	@Override
	public void eliminarProgramacion(int idProgram) {
		programacionRepository.deleteById(idProgram);
		
	}

}
