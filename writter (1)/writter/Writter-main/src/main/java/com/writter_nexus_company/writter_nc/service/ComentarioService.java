package com.writter_nexus_company.writter_nc.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writter_nexus_company.writter_nc.model.Comentario;
import com.writter_nexus_company.writter_nc.repository.ComentarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findAll(){
        return comentarioRepository.findAll();
    }

    public Comentario findById(Long id){
        return comentarioRepository.findById(id).orElse(null);
    }

    public Comentario save(Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    public void delete(Long idcomentario){
        comentarioRepository.deleteById(idcomentario);
    }

    public Comentario patchComentario(Long id, Comentario parcialComentario){
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(id);
        if (comentarioOptional.isPresent()) {
            
            Comentario comentarioToUpdate = comentarioOptional.get();
            
            if (parcialComentario.getContenido() != null) {
                comentarioToUpdate.setContenido(parcialComentario.getContenido());
            }
            return comentarioToUpdate;
        } else {
            return null;
        }
    }

    public List<Comentario> findByIdComentario(Long idComentario) {
        return comentarioRepository.findByIdComentario(idComentario);
    }

}
