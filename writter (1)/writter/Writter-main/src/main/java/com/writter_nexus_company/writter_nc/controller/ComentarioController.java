package com.writter_nexus_company.writter_nc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable; // <-- Add this import
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writter_nexus_company.writter_nc.model.Comentario;
import com.writter_nexus_company.writter_nc.service.ComentarioService;

@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        List<Comentario> comentarios = comentarioService.findAll();
        if (comentarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comentarios);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentario(@PathVariable Long id) {
        Comentario comentario = comentarioService.findById(id);
        if (comentario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comentario);
    }


    @PostMapping
    public ResponseEntity<Comentario> guardarComentario(@RequestBody Comentario comentario) {
        Comentario savedComentario = comentarioService.save(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComentario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        Comentario updatedComentario = comentarioService.patchComentario(id, comentario);
        if (updatedComentario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedComentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        try {
            comentarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchComentario(@PathVariable Long id, @RequestBody Comentario parcialComentario) {
        Comentario updatedComentario = comentarioService.patchComentario(id, parcialComentario);
        if (updatedComentario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedComentario);
    }

}