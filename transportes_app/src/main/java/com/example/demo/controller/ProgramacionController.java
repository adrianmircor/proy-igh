package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Bus;
import com.example.demo.model.Ciudad;
import com.example.demo.model.Empleado;
import com.example.demo.model.Programacion;
import com.example.demo.model.Ruta;
import com.example.demo.service.IBusService;
import com.example.demo.service.IProgramacionService;
import com.example.demo.service.IRutaService;

@Controller
@RequestMapping("/programacion")
public class ProgramacionController {
	
	
	@Autowired
	IRutaService iRutaService;
	
	@Autowired
	IProgramacionService iProgramacionService;
	
	@Autowired
	IBusService iBusService;
	

	@GetMapping("")
	public String programacionGeneral(Programacion programacion) {
		
		return "programacion/programacionGeneral";
	}
	
	
	@GetMapping("/ruta/{id}")
	public String programacionRuta(
			@PathVariable("id") int idRuta,
			Programacion programacion,
			HttpSession session,
			Model model) {
		
		//Guardar session de la ruta
		Ruta ruta = iRutaService.buscarRuta(idRuta);
		session.setAttribute("sessionRuta", ruta);
		
		List<Programacion> listaProgramacion;
		//Buscar los buses que estan con esa ruta
		listaProgramacion = iProgramacionService.listaProgramacionPorRuta(idRuta);
		model.addAttribute("ListaProgramacionPorRuta", listaProgramacion);
		System.out.println(listaProgramacion);
		//
		
		
		
		return "programacion/programacionRuta";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editarProgramacion(
			@PathVariable("id") int idProgram,
			HttpSession session,
			Model model) {
		
		Programacion programacion = iProgramacionService.recuperarProgramacion(idProgram);
		model.addAttribute("programacion", programacion);
		
		List<Programacion> listaProgramacion;

		//Recupera la sesion y Buscar los buses que estan con esa ruta
		Ruta ruta = (Ruta)session.getAttribute("sessionRuta");
		listaProgramacion = iProgramacionService.listaProgramacionPorRuta(ruta.getIdRuta());
		model.addAttribute("ListaProgramacionPorRuta", listaProgramacion);
		
		
		return "programacion/programacionRuta";
		
	}
	
	@PostMapping("/save")
	public String guardarProgramacion(Programacion programacion, HttpSession session) {
		
		Bus bus = iBusService.soloBusPorPlaca(programacion.getBus().getPlaca());
		programacion.setBus(bus);
		
		Empleado emp =(Empleado)session.getAttribute("sessionEmpleado");
		programacion.setEmpleado(emp);
		
		Ruta ruta = (Ruta)session.getAttribute("sessionRuta");
		programacion.setRuta(ruta);
		
		iProgramacionService.guardarProgramacion(programacion);
		
		return "redirect:/programacion/ruta/"+ruta.getIdRuta();

	}
	
	@GetMapping("/delete/{id}")
	public String eliminarProgramacion(
			@PathVariable("id") int idProgram,
			HttpSession session) {
		
		iProgramacionService.eliminarProgramacion(idProgram);
		Ruta ruta = (Ruta)session.getAttribute("sessionRuta");

		return "redirect:/programacion/ruta/"+ruta.getIdRuta();
	}
	
}
