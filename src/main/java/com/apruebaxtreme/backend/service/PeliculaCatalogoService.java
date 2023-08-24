package com.apruebaxtreme.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;
import com.apruebaxtreme.backend.repository.PeliculaCatalogoRepository;

@Service
public class PeliculaCatalogoService {

    @Autowired
    PeliculaCatalogoRepository peliculaCatalogoRepository;

    public PeliculaCatalogo guardarPeliculaCatalogo(PeliculaCatalogo peliculaCatalogo){
        return peliculaCatalogoRepository.save(peliculaCatalogo);
    }
    
}
