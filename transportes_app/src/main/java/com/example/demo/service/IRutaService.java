package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ruta;

public interface IRutaService {
	
	//Buses por ruta
	//falta
	
	public void guardarRuta(Ruta ruta);
	public void eliminarRuta(Integer idRuta);
	public List<Ruta> listaRutas();
	
	//Retorna la ruta para enviar a edición
	public Ruta buscarRuta(Integer idRuta);

}
