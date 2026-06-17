package com.example.ProyectoAgronomiaGrupo5.security;

import com.example.ProyectoAgronomiaGrupo5.Models.Usuario;
import com.example.ProyectoAgronomiaGrupo5.Repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repo.findOneByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        // Cambio 1: prefijo ROLE_ requerido por Spring Security
        usuario.getRoles().forEach(rol ->
                roles.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre()))
        );

        // Cambio 2: constructor con "activo" incluido
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getActivo(),  // enabled
                true,                 // accountNonExpired
                true,                 // credentialsNonExpired
                true,                 // accountNonLocked
                roles
        );
    }
}