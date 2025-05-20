package com.writter_nexus_company.writter_nc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.writter_nexus_company.writter_nc.model.Comentario;


@Repository
public interface  ComentarioRepository extends JpaRepository <Comentario, Long> {
    List<Comentario> findByIdComentario(Long idComentario);

}
