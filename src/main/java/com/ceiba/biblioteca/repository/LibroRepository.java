package com.ceiba.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.entities.LibroEntity;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long>{
	
	LibroEntity findByIsbn(String isbn);
}
