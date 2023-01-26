package com.ceiba.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.entities.PrestamoEntity;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long>{


	//@Query("select * from PrestamoEntity p where p.esFinalizado = ?1")
	List<PrestamoEntity> findByEsFinalizado(Boolean esFinalizado);
	
	PrestamoEntity findByIdPrestamo(Long idPrestamod);
}
