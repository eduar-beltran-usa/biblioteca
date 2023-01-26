package com.ceiba.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.dto.ObtenerPrestamoResponseDTO;
import com.ceiba.biblioteca.dto.PrestamoRequestDTO;
import com.ceiba.biblioteca.dto.PrestamoResponseDTO;
import com.ceiba.biblioteca.service.PrestamoService;
import com.ceiba.biblioteca.service.PrestamoServiceImpl;

import lombok.val;

@RestController
@RequestMapping(value = "/prestamo")
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;

	@PostMapping(consumes = { "application/json" }, 
				 produces = { "application/json" })
	ResponseEntity<PrestamoResponseDTO> crearPrestamo(@RequestBody PrestamoRequestDTO requestDTO) {

		PrestamoResponseDTO responseDTO = new PrestamoResponseDTO();

		responseDTO = prestamoService.crearPrestamo(requestDTO);

		if (responseDTO.getMensaje() == "Tipo de usuario no permitido en la biblioteca") {
			ResponseEntity<PrestamoResponseDTO> res = new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
			return res;
		}

		ResponseEntity<PrestamoResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);

		return response;
	}
	
	@GetMapping(value = "/{id-prestamo}")
	ResponseEntity<ObtenerPrestamoResponseDTO> obtenerPrestamo(@PathVariable(value = "id-prestamo") Long idPrestamo){
		
		ObtenerPrestamoResponseDTO responseDTO = new ObtenerPrestamoResponseDTO();
		
		responseDTO = prestamoService.obtenerPrestamo(idPrestamo);
		
		ResponseEntity<ObtenerPrestamoResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
		
		return response;
	}

}
