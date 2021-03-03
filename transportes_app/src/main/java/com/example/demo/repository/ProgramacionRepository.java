package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Programacion;

public interface ProgramacionRepository extends JpaRepository<Programacion, Integer> {

	@Query(value = ""
			+ "select * "
			+ "from programacion p "
			+ "join bus b ON p.IDBUS = b.IDBUS "
			+ "where p.IDRUTA = :idRuta", nativeQuery = true)
	List<Programacion> buscarPorRuta(int idRuta);
	
}
