package com.apruebaxtreme.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.models.Usuario;

import java.util.List;


public interface PeliculaAlquiladaRepository extends JpaRepository<PeliculaAlquilada, Long> {

    List<PeliculaAlquilada> findByUsuario(Usuario usuario);
    
}
