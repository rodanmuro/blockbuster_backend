package com.apruebaxtreme.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;
import com.apruebaxtreme.backend.service.PeliculaCatalogoService;

@RestController
public class PeliculaCatalogoController {

    @Autowired
    PeliculaCatalogoService peliculaCatalogoService;

    @PostMapping("/peliculacatalogo")
    public ResponseEntity<PeliculaCatalogo> guardarPeliculaCatalogo(@RequestBody PeliculaCatalogo peliculaCatalogo){
        
        PeliculaCatalogo peliculaCatalogoGuardada = peliculaCatalogoService.guardarPeliculaCatalogo(peliculaCatalogo);

        return new ResponseEntity<PeliculaCatalogo>(peliculaCatalogoGuardada, HttpStatus.OK);
    }
    
}
