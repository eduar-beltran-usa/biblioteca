package com.ceiba.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.entities.TipoUsuarioEntity;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Long>{

	TipoUsuarioEntity findByIdTipo(Long idTipo);
}
