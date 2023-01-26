package com.ceiba.biblioteca.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoResponseDTO implements Serializable {

	private static final long serialVersionUID = -2060066220052902630L;
	
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fechaMaximaDevolucion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mensaje;

}
