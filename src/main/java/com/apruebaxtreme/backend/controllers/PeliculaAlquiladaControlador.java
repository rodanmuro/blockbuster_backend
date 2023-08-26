package com.apruebaxtreme.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.dto.PeliculaAlquiladaDTO;
import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.service.PeliculaAlquiladaService;

@RestController
public class PeliculaAlquiladaControlador {

    @Autowired
    PeliculaAlquiladaService peliculaAlquiladaService;

    @GetMapping("/peliculaalquilada")
    public ResponseEntity<List<PeliculaAlquiladaDTO>> obtenerPeliculasAlquiladas(){

        try {
            List<PeliculaAlquiladaDTO> peliculaAlquiladas 
            = peliculaAlquiladaService.obtenerPeliculasAlquiladas();
            return new ResponseEntity<List<PeliculaAlquiladaDTO>>(peliculaAlquiladas, HttpStatus.OK);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
