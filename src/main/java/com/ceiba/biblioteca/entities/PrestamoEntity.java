package com.ceiba.biblioteca.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "prestamos")
public class PrestamoEntity implements Serializable {
	
	private static final long serialVersionUID = -3558133873603627953L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @Column(name = "fecha_prestamo")
    private Date fechaPrestamo;

    @Column(name = "fecha_devolucion")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaDevolucion;

    @Column(name = "es_finalizado")
    private Boolean esFinalizado;
    
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "libro_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "prestamos"})
    private LibroEntity libro;
    
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "prestamos"})
    private UsuarioEntity usuario;
    
//    @Column(name = "id_libro")
//    private Long idLibro;
//
//    @Column(name = "id_usuario")
//    private Long idUsuario;

}
