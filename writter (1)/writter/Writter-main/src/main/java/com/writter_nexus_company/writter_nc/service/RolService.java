package com.writter_nexus_company.writter_nc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writter_nexus_company.writter_nc.model.Rol;
import com.writter_nexus_company.writter_nc.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll(){
        return rolRepository.findAll();
    }

    public Rol findById(Long id){
        return rolRepository.findById(id).orElse(null);
    }
    public Rol save(Rol rol){
        return rolRepository.save(rol);
    }

    public void delete(Long id){
        rolRepository.deleteById(id);
    }

    public Rol patchRol(Long id, Rol parcialrol){
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (rolOptional.isPresent()) {
            
            Rol rolToUpdate = rolOptional.get();
            
            if (parcialrol.getNombreRol() != null) {
                rolToUpdate.setNombreRol(parcialrol.getNombreRol());
            }

            if(parcialrol.getId() != null) {
                rolToUpdate.setId(parcialrol.getId());
            }

            return rolRepository.save(rolToUpdate);
        } else {
            return null;
        }
    }
}
