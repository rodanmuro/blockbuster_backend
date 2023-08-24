package com.apruebaxtreme.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apruebaxtreme.backend.models.PeliculaCatalogo;

public interface PeliculaCatalogoRepository extends JpaRepository<PeliculaCatalogo, Integer>{
    
}
