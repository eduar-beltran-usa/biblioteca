package com.ceiba.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
	UsuarioEntity findByNroIdentificacion(String nroIdentificacion);
}
