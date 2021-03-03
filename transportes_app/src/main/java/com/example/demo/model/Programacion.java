package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAMACION")
public class Programacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="IDPROGRAMACION")
	private Integer idProgramacion;
	
	@Column(name="SALIDA_PROGRAMADA")
	private String salidaProgramada;
	
	@Column(name="LLEGADA_PROGRAMADA")
	private String llegadaProgramada;
	
	@Column(name="SALIDA_REAL")
	private String salidaReal;
	
	@Column(name="LLEGADA_REAL")
	private String llegadaReal;
	
	@ManyToOne
	@JoinColumn(name="IDEMPLEADO")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="IDBUS")
	private Bus bus;
	
	@ManyToOne
	@JoinColumn(name="IDRUTA")
	private Ruta ruta;
	
	@Column(name="CANT_PASAJES_ESTANDAR")
	private Integer cantidadPasajesEstandar;
	
	@Column(name="CANT_PASAJES_PREMIUM")
	private Integer cantidadPasajesPremium;

	public Integer getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public String getSalidaProgramada() {
		return salidaProgramada;
	}

	public void setSalidaProgramada(String salidaProgramada) {
		this.salidaProgramada = salidaProgramada;
	}

	public String getLlegadaProgramada() {
		return llegadaProgramada;
	}

	public void setLlegadaProgramada(String llegadaProgramada) {
		this.llegadaProgramada = llegadaProgramada;
	}

	public String getSalidaReal() {
		return salidaReal;
	}

	public void setSalidaReal(String salidaReal) {
		this.salidaReal = salidaReal;
	}

	public String getLlegadaReal() {
		return llegadaReal;
	}

	public void setLlegadaReal(String llegadaReal) {
		this.llegadaReal = llegadaReal;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Integer getCantidadPasajesEstandar() {
		return cantidadPasajesEstandar;
	}

	public void setCantidadPasajesEstandar(Integer cantidadPasajesEstandar) {
		this.cantidadPasajesEstandar = cantidadPasajesEstandar;
	}

	public Integer getCantidadPasajesPremium() {
		return cantidadPasajesPremium;
	}

	public void setCantidadPasajesPremium(Integer cantidadPasajesPremium) {
		this.cantidadPasajesPremium = cantidadPasajesPremium;
	}

	@Override
	public String toString() {
		return "Programacion [idProgramacion=" + idProgramacion + ", salidaProgramada=" + salidaProgramada
				+ ", llegadaProgramada=" + llegadaProgramada + ", salidaReal=" + salidaReal + ", llegadaReal="
				+ llegadaReal + ", empleado=" + empleado + ", bus=" + bus + ", ruta=" + ruta
				+ ", cantidadPasajesEstandar=" + cantidadPasajesEstandar + ", cantidadPasajesPremium="
				+ cantidadPasajesPremium + "]";
	}
	
	
}
