package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RUTA")
public class Ruta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="IDRUTA")
	private Integer idRuta;
	
	@OneToOne
	@JoinColumn(name ="CIUDAD_ORIGEN")
	private Ciudad ciudadOrigen;
	
	@OneToOne
	@JoinColumn(name ="CIUDAD_DESTINO")
	private Ciudad ciudadDestino;
	
	@Column(name="TIEMPO_VIAJE")
	private String tiempoViaje;
	
	@Column(name="PRECIO_ESTANDAR")
	private double precioEstandar;
	
	@Column(name="PRECIO_PREMIUM")
	private double precioPremium;

	public Integer getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public String getTiempoViaje() {
		return tiempoViaje;
	}

	public void setTiempoViaje(String tiempoViaje) {
		this.tiempoViaje = tiempoViaje;
	}

	public double getPrecioEstandar() {
		return precioEstandar;
	}

	public void setPrecioEstandar(double precioEstandar) {
		this.precioEstandar = precioEstandar;
	}

	public double getPrecioPremium() {
		return precioPremium;
	}

	public void setPrecioPremium(double precioPremium) {
		this.precioPremium = precioPremium;
	}

	@Override
	public String toString() {
		return "Ruta [idRuta=" + idRuta + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino
				+ ", tiempoViaje=" + tiempoViaje + ", precioEstandar=" + precioEstandar + ", precioPremium="
				+ precioPremium + "]";
	}

	
	

	
	
	

}
