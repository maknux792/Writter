package com.writter_nexus_company.writter_nc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.writter_nexus_company.writter_nc.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{

    Rol findById (Integer id);
    List<Rol> findAll ();
}
