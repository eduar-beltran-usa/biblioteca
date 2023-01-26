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
@Table(name = "tipo_usuarios")
public class TipoUsuarioEntity implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 2380945920453546117L;

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "descripcion_usuario")
    private String descripcion;

    @Column(name = "dias_prestamo")
    private Integer diasPrestamo;
    
    @OneToMany(
            mappedBy = "tipoUsuario",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"tipoUsuario"})
    private List<UsuarioEntity> usuarios;
}
