package com.ceiba.biblioteca.dto;

import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoRequestDTO implements Serializable {

	private static final long serialVersionUID = -1427199627438391177L;
	
	@Size(max = 10)
    private String isbn;
	@Size(max = 10)
    private String identificacionUsuario;
    private Long tipoUsuario;

}
