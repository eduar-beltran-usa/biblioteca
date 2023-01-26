package com.ceiba.biblioteca.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.biblioteca.dto.ObtenerPrestamoResponseDTO;
import com.ceiba.biblioteca.dto.PrestamoRequestDTO;
import com.ceiba.biblioteca.dto.PrestamoResponseDTO;
import com.ceiba.biblioteca.entities.LibroEntity;
import com.ceiba.biblioteca.entities.PrestamoEntity;
import com.ceiba.biblioteca.entities.TipoUsuarioEntity;
import com.ceiba.biblioteca.entities.UsuarioEntity;
import com.ceiba.biblioteca.repository.LibroRepository;
import com.ceiba.biblioteca.repository.PrestamoRepository;
import com.ceiba.biblioteca.repository.TipoUsuarioRepository;
import com.ceiba.biblioteca.repository.UsuarioRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private PrestamoRepository prestamoRepository;

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public PrestamoResponseDTO crearPrestamo(PrestamoRequestDTO prestamoRequestDTO) {

		PrestamoResponseDTO responseDTO = new PrestamoResponseDTO();
		PrestamoEntity prestamo = new PrestamoEntity();

		UsuarioEntity usuario = usuarioRepository
				.findByNroIdentificacion(prestamoRequestDTO.getIdentificacionUsuario());
		LibroEntity libro = libroRepository.findByIsbn(prestamoRequestDTO.getIsbn());
		TipoUsuarioEntity tipoUsuario = tipoUsuarioRepository.findByIdTipo(prestamoRequestDTO.getTipoUsuario());

		if (usuario == null) {
			responseDTO.setMensaje(
					String.format("El usuario con identificacion %s no existe", prestamoRequestDTO.getIdentificacionUsuario()));
			return responseDTO;
		}

		if (tipoUsuario == null) {
			responseDTO.setMensaje("Tipo de usuario no permitido en la biblioteca");
			return responseDTO;
		}

		if (libro == null) {
			responseDTO.setMensaje(String.format("el libro con isbn %s no existe", prestamoRequestDTO.getIsbn()));
			return responseDTO;
		}

		if (prestamoRequestDTO.getTipoUsuario() == 3) {
			if (Objects.nonNull(prestamoRepository.findByEsFinalizado(false))) {
				responseDTO.setMensaje(String.format(
						"El usuario con identificación %s ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",
						prestamoRequestDTO.getIdentificacionUsuario()));
				return responseDTO;
			}
		}

		switch (prestamoRequestDTO.getTipoUsuario().toString()) {
		case "1":
			prestamo.setFechaDevolucion(LocalDate.now().plusDays(10));
			break;
		case "2":
			prestamo.setFechaDevolucion(LocalDate.now().plusDays(8));
			break;
		case "3":
			prestamo.setFechaDevolucion(LocalDate.now().plusDays(7));
			break;

		default:
			break;
		}

		prestamo.setFechaPrestamo(new Date());
		prestamo.setEsFinalizado(false);
		prestamo.setLibro(libro);
		prestamo.setUsuario(usuario);
		prestamo.setFechaDevolucion(LocalDate.now());
		
		switch (prestamoRequestDTO.getTipoUsuario().toString()) {
		case "1":
			prestamo.setFechaDevolucion(LocalDate.now().plusDays(10));
			break;
		case "2":
			prestamo.setFechaDevolucion(LocalDate.now().plusDays(8));
			break;
		case "3":
			prestamo.setFechaDevolucion(LocalDate.now().plusDays(7));
			break;

		default:
			break;
		}

		prestamo = prestamoRepository.save(prestamo);

		responseDTO.setId(prestamo.getIdPrestamo());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		responseDTO.setFechaMaximaDevolucion(formatter.format(prestamo.getFechaDevolucion()));

		return responseDTO;
	}

	@Override
	public ObtenerPrestamoResponseDTO obtenerPrestamo(Long idPrestamo) {
		
		ObtenerPrestamoResponseDTO responseDTO = new ObtenerPrestamoResponseDTO();
		
		PrestamoEntity prestamo = new PrestamoEntity();
		
		prestamo = prestamoRepository.findByIdPrestamo(idPrestamo);
		
		responseDTO.setId(prestamo.getIdPrestamo());
		responseDTO.setIsbn(prestamo.getLibro().getIsbn());
		responseDTO.setIdentificacionUsuario(prestamo.getUsuario().getNroIdentificacion());
		responseDTO.setTipoUsuario(prestamo.getUsuario().getTipoUsuario().getIdTipo());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		responseDTO.setFechaMaximaDevolucion(formatter.format(prestamo.getFechaDevolucion()));
		
		return responseDTO;
	}

}
