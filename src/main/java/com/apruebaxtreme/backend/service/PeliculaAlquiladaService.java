package com.apruebaxtreme.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.apruebaxtreme.backend.dto.PeliculaAlquiladaDTO;
import com.apruebaxtreme.backend.exceptions.PeliculaAlquiladaDuplicadaException;
import com.apruebaxtreme.backend.models.PeliculaAlquilada;
import com.apruebaxtreme.backend.models.PeliculaCatalogo;
import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.repository.PeliculaAlquiladaRepository;
import com.apruebaxtreme.backend.repository.PeliculaCatalogoRepository;
import com.apruebaxtreme.backend.repository.UsuarioRepository;

@Service
public class PeliculaAlquiladaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PeliculaCatalogoRepository peliculaCatalogoRepository;

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

    public PeliculaAlquiladaDTO alquilarPelicula(Integer idPelicula) throws NotFoundException, PeliculaAlquiladaDuplicadaException{

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);
        optionalUsuario.orElseThrow(()->new NotFoundException());

        List<PeliculaCatalogo> peliculasCatalogo = peliculaCatalogoRepository.findByIdPelicula(idPelicula);

        if(peliculasCatalogo.size()==0){
            throw new NotFoundException();
        }

        Usuario usuario = optionalUsuario.get();
        PeliculaCatalogo peliculaCatalogo = peliculasCatalogo.get(0);

        List<PeliculaAlquilada> peliculasAlquiladas = peliculaAlquiladaRepository.findByPeliculaCatalogo(peliculaCatalogo);

        if(peliculasAlquiladas.size()>0){
            throw new PeliculaAlquiladaDuplicadaException("La pelicula que se quiera alquilar ya lo está");
        }

        PeliculaAlquilada peliculaAlquilada = new PeliculaAlquilada(usuario, peliculaCatalogo);

        PeliculaAlquilada peliculaAlquilada2 
        = peliculaAlquiladaRepository.save(peliculaAlquilada);

        PeliculaAlquiladaDTO peliculaAlquiladaDTO 
        = new PeliculaAlquiladaDTO(peliculaAlquilada2.getIdAlquilada(), peliculaCatalogo);

        return peliculaAlquiladaDTO;
    }
    
}
