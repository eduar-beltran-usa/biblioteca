package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.dto.ObtenerPrestamoResponseDTO;
import com.ceiba.biblioteca.dto.PrestamoRequestDTO;
import com.ceiba.biblioteca.dto.PrestamoResponseDTO;

public interface PrestamoService {

	PrestamoResponseDTO crearPrestamo(PrestamoRequestDTO prestamoRequestDTO);
	
	ObtenerPrestamoResponseDTO obtenerPrestamo(Long idPrestamo);
}
