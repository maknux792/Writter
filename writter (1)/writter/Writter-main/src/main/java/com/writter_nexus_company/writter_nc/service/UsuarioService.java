package com.writter_nexus_company.writter_nc.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writter_nexus_company.writter_nc.model.Usuario;
import com.writter_nexus_company.writter_nc.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public Usuario patchUsuario(Long id, Usuario parcialusuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            
            Usuario usuarioToUpdate = usuarioOptional.get();
            
            if (parcialusuario.getNombreUsuario() != null) {
                usuarioToUpdate.setNombreUsuario(parcialusuario.getNombreUsuario());
            }

            if(parcialusuario.getIdUsuario() != null) {
                usuarioToUpdate.setIdUsuario(parcialusuario.getIdUsuario());
            }

            if (parcialusuario.getEmailUsuario() != null) {
                usuarioToUpdate.setEmailUsuario(parcialusuario.getEmailUsuario());
            }

            if(parcialusuario.getContrasena() != null) {
                usuarioToUpdate.setContrasena(parcialusuario.getContrasena());
            }

            return usuarioRepository.save(usuarioToUpdate);
        }
        return null;
    }

}
