package com.apruebaxtreme.backend.config;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.repository.UsuarioRepository;

@Configuration
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(username);

        if(!optionalUsuario.isPresent()){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        
        User usuario = new User(username, optionalUsuario.get().getPassword(), new ArrayList<GrantedAuthority>());
        
        return usuario;
    }
    
}
