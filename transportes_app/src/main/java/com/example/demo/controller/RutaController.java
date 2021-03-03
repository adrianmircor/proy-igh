package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Ciudad;
import com.example.demo.model.Ruta;
import com.example.demo.service.ICiudadService;
import com.example.demo.service.IRutaService;

@Controller
@RequestMapping("/rutas")
public class RutaController {

	@Autowired
	ICiudadService iCiudadService;
	
	@Autowired
	IRutaService iRutaService;

	@GetMapping("")
	public String ruta(Ruta ruta) {

		
		return "rutas/agregarRuta";
	}

	@PostMapping("/save")
	public String guardarRuta(Ruta ruta) {
		
		System.out.println("La ruta: "+ruta);
		
		iRutaService.guardarRuta(ruta);

		return "redirect:/rutas";
	}
	
	@GetMapping("/edit/{id}")
	public String editarRuta(
			@PathVariable("id") int idRuta,
			Model model) {
		
		Ruta ruta = iRutaService.buscarRuta(idRuta);
		
		System.out.println("La ruta editar: "+ruta);

		
		model.addAttribute("ruta", ruta);
		
		return "rutas/editarRuta";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarRuta(
			@PathVariable("id") int idRuta) {
		
		
		iRutaService.eliminarRuta(idRuta);
		
		return "redirect:/rutas";
	}

	@ModelAttribute
	public void modelGeneric(Model model) {

		List<Ciudad> listCiudad = iCiudadService.listCiudades();
		model.addAttribute("ListaCiudades", listCiudad);
		
		List<Ruta> listRuta = iRutaService.listaRutas();
		model.addAttribute("ListaRutas", listRuta);

	}
}
