package com.apruebaxtreme.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.repository.PeliculaAlquiladaRepository;
import com.apruebaxtreme.backend.repository.UsuarioRepository;

@Service
public class PeliculaAlquiladaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private String email="user2@email.com";

    @Autowired
    PeliculaAlquiladaRepository peliculaAlquiladaRepository;

    public List<PeliculaAlquilada> obtenerPeliculasAlquiladas() throws NotFoundException{

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        optionalUsuario.orElseThrow(()->new NotFoundException());

        List<PeliculaAlquilada> peliculasAlquiladas 
        = peliculaAlquiladaRepository.findByUsuario(optionalUsuario.get());

        return peliculasAlquiladas;
                
    }
    
}
