package com.writter_nexus_company.writter_nc.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="libro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @Column(nullable = false, length = 30)
    private String titulo;

    @Column(nullable = false, length = 15) 
    private String generoLibro;

    @Column(nullable = false, length = 30)
    private String autor;

    @Column(nullable = false, length = 30)
    private String nombreLibro;

    @Column(nullable = false)
    private Date fechaPub;

    @Column(nullable = false)
    private Date fechaAct;

    @Column(nullable = false, length = 30)
    private String categoria;

}