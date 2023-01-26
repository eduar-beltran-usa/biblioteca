package com.ceiba.biblioteca.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "libros")
public class LibroEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6699770224336956637L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private Long id;
	
	@Column(name = "isbn_libro")
	@Size(max = 10)
	@NotEmpty
	private String isbn;
	
	@Column(name = "titulo_libro")
	@Size(max = 100)
	@NotEmpty
	private String titulo;
	
	@Column(name = "autor_libro")
	@Size(max = 10)
	@NotEmpty
	private String autor;
	
	@Column(name = "anio_libro")
	@Size(max = 10)
	@NotEmpty
	private Integer anio;
	
    @OneToMany(
            mappedBy = "libro",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"libro"})
    private List<PrestamoEntity> prestamos;
	
	
	
}
