package com.apruebaxtreme.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.dto.UsuarioDTO;
import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping("/usuario")
    public UsuarioDTO registrarUsuario(@RequestBody Usuario usuario){
         usuario.setRol("USER");
         
         if(usuario.getPassword().length()<8){
            return new UsuarioDTO(usuario.getEmail(), "longitud de contraseña menor a 8");
         }

         return usuarioService.registrarUsuario(usuario);
    }
}
