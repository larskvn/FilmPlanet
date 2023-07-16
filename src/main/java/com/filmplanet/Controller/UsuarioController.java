package com.filmplanet.Controller;

import com.filmplanet.Entity.UsuarioDTO;
import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Repository.UsuarioRepository;
import com.filmplanet.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

    /*@Autowired
    PasswordEncoder passwordEncoder;*/


    @GetMapping
    public List<UsuariosEntity> findAll(){
        return usuarioService.findAll();
    }



    @GetMapping("/userLogin/actual")
    public ResponseEntity<UsuarioDTO> getUserDetails(Authentication authentication) {
        String username = authentication.getName();
        UsuariosEntity usuarioEntity = usuarioRepository.findByUsername(username);

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUserid(usuarioEntity.getUserid());
        usuarioDTO.setUsername(usuarioEntity.getUsername());
        usuarioDTO.setLastname(usuarioEntity.getLastname());
        usuarioDTO.setRol(usuarioEntity.getRol());
        usuarioDTO.setEnable(usuarioEntity.isEnable());

        return ResponseEntity.ok(usuarioDTO);
    }
}
