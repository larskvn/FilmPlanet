package com.filmplanet.Controller;

import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Enum.Rol;
import com.filmplanet.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create-admin")
public class RegistreAdminController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping()
    public UsuariosEntity save(@RequestBody UsuariosEntity usuario) throws Exception{
        usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(Rol.ADMIN);
        return usuarioService.save(usuario);
    }
}
