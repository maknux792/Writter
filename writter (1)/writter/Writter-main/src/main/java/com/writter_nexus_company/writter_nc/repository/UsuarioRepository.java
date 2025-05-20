package com.writter_nexus_company.writter_nc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.writter_nexus_company.writter_nc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
