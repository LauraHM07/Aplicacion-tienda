package com.laura.springprojects.tienda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.model.Permiso;
import com.laura.springprojects.tienda.model.Usuario;
import com.laura.springprojects.tienda.repository.UsuarioRepository;

@Service
public class UsuariosService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository userRepository;

    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    public Usuario updateUser(Usuario user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public Usuario getUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = userRepository.findByNombre(username);

        List<Permiso> permisosUsuario = usuario.getPermissions();
        List<GrantedAuthority> permisos = new ArrayList<GrantedAuthority>();

        for (Permiso permiso : permisosUsuario){
            permisos.add(new SimpleGrantedAuthority(permiso.getNombre()));
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
            .username(usuario.getNombre())
            .password(usuario.getPassword())
            .authorities(permisos)
            .build();
        
        return userDetails;
    }
}
