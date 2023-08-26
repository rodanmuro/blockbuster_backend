package com.apruebaxtreme.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.apruebaxtreme.backend.dto.PeliculaAlquiladaDTO;
import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.repository.PeliculaAlquiladaRepository;
import com.apruebaxtreme.backend.repository.UsuarioRepository;

@Service
public class PeliculaAlquiladaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private String email="user3@email.com";

    @Autowired
    PeliculaAlquiladaRepository peliculaAlquiladaRepository;

    public List<PeliculaAlquiladaDTO> obtenerPeliculasAlquiladas() throws NotFoundException{

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        optionalUsuario.orElseThrow(()->new NotFoundException());

        List<PeliculaAlquilada> peliculasAlquiladas 
        = peliculaAlquiladaRepository.findByUsuario(optionalUsuario.get());

        List<PeliculaAlquiladaDTO> peliculasAlquiladasDTO
        =peliculasAlquiladas.stream().map(
            peliculaAlquilada->{
                return new PeliculaAlquiladaDTO(peliculaAlquilada.getIdAlquilada(), peliculaAlquilada.getPeliculaCatalogo());
            }
        ).collect(Collectors.toList());

        return peliculasAlquiladasDTO;             
    }
    
}
