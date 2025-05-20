package com.writter_nexus_company.writter_nc.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writter_nexus_company.writter_nc.model.Libro;
import com.writter_nexus_company.writter_nc.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }

    public Libro findById(Long id){
        return libroRepository.findById(id).orElse(null);
    }

    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }

    public void delete(Long id){
        libroRepository.deleteById(id);
    }

    public Libro patchRol(Long id, Libro parciallibro){
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()) {
            
            Libro libroToUpdate = libroOptional.get();
            
            if (parciallibro.getAutor() != null) {
                libroToUpdate.setAutor(parciallibro.getAutor());
            }

            if(parciallibro.getIdLibro() != null) {
                libroToUpdate.setIdLibro(parciallibro.getIdLibro());
            }

            if (parciallibro.getNombreLibro() !=null) {
                libroToUpdate.setNombreLibro(parciallibro.getNombreLibro());
            }

            if(parciallibro.getGeneroLibro() != null) {
                libroToUpdate.setGeneroLibro(parciallibro.getGeneroLibro());
            }

            if (parciallibro.getFechaPub() != null) {
                libroToUpdate.setFechaPub(parciallibro.getFechaPub());
            }

            if(parciallibro.getFechaAct() != null) {
                libroToUpdate.setFechaAct(parciallibro.getFechaAct());
            }

            if (parciallibro.getCategoria() != null) {
                libroToUpdate.setCategoria(parciallibro.getCategoria());
            }

            return libroRepository.save(libroToUpdate);
        } else {
            return null;
        }
    }



    public List<Libro> findByGenero(String generoLibro) {
        return libroRepository.findByGeneroLibro(generoLibro);
    }

    public List<Libro> findByCategoria(String categoria) {
        return libroRepository.findByCategoria(categoria);
    }
    public List<Libro> findByNombreAutor(String nombreAutor) {
        return libroRepository.findByAutor(nombreAutor);
    }

    public List<Libro> findByTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }
}
