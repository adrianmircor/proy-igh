package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{
	
	@Query(value = "select * from BUS b "
			+ "inner join FABRICANTE f on b.IDFABRICANTE = f.IDFABRICANTE "
			+ "where b.PLACA like %:filtro% or f.NOMBRE like %:filtro%", nativeQuery = true)
	List<Bus> buscarPorPlaca(String filtro);
	
	
	public Bus findByPlaca(String placa);
	
}
