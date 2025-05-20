package com.writter_nexus_company.writter_nc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(unique=false, nullable=false, length=20)
    private String contrasena;

    @Column(unique=true, nullable=false, length=30)
    private String emailUsuario;

    @Column(unique=false, nullable=false, length=15)
    private String nombreUsuario;
}
