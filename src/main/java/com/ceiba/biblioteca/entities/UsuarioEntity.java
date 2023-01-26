package com.ceiba.biblioteca.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable{
	

	private static final long serialVersionUID = -7159744071299010090L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nroidentificacion_usuario", unique = true)
    @Size(max=10)
    @NotEmpty
    private String nroIdentificacion;
	
    @Column(name = "nombre_usuario")
    @NotEmpty
    private String nombre;
    
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "id_tipo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "usuarios"})
    private TipoUsuarioEntity tipoUsuario;
    
    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"usuario"})
    private List<PrestamoEntity> prestamos;



}
