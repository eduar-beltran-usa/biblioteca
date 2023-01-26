package com.ceiba.biblioteca.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtenerPrestamoResponseDTO extends PrestamoResponseDTO implements Serializable{

	private static final long serialVersionUID = -4908641716056905288L;
	
    private String isbn;
    private String identificacionUsuario;
    private Long tipoUsuario;

}
