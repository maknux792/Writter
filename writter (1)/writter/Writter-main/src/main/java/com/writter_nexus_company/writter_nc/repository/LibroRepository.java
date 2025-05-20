package com.writter_nexus_company.writter_nc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.writter_nexus_company.writter_nc.model.Libro;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByAutor(String nombreAutor);
    List<Libro> findByCategoria(String categoria);
    List<Libro> findByTitulo(String titulo);
    List<Libro> findByGeneroLibro(String generoLibro);
}
