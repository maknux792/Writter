package com.writter_nexus_company.writter_nc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comentarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentarios {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_comentario", nullable=false)
    private Comentario comentario;
    
    @ManyToOne
    @JoinColumn(name="libro_id", nullable=false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
}
