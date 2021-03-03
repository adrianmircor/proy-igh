package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Programacion;

public interface IProgramacionService {

	public List<Programacion> listaProgramacionPorRuta(int idRuta);
	
	public Programacion recuperarProgramacion(Integer idProgramacion);
	
	public void guardarProgramacion(Programacion programacion);
	
	public void eliminarProgramacion(int idProgram);

}
