package com.filmplanet.Controller;

import com.filmplanet.Entity.UsuarioDTO;
import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Enum.Rol;
import com.filmplanet.Repository.UsuarioRepository;
import com.filmplanet.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/create-user")
public class RegistryUserController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping()
    public UsuariosEntity save(@RequestBody UsuariosEntity usuario) throws Exception{
        usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(Rol.USER);
        return usuarioService.save(usuario);
    }

    /*
    @PostMapping("/admin")
    public UsuariosEntity save(@RequestBody UsuariosEntity usuario) throws Exception{
        usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(Rol.ADMIN);
        return usuarioService.save(usuario);
    }*/



}
