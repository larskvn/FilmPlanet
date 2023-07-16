package com.filmplanet.Controller;

import com.filmplanet.Entity.UsuarioDTO;
import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Repository.UsuarioRepository;
import com.filmplanet.Service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuariosEntity> deleteUsuario(@PathVariable Long id) {
        UsuariosEntity usuarioEntity = usuarioService.getUsuarioById(id);
        if (usuarioEntity == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioEntity.setEnable(false);
        UsuariosEntity updatedUsuario = usuarioService.update(usuarioEntity);
        return ResponseEntity.ok(updatedUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosEntity> updateUsuario(@PathVariable Long id, @RequestBody UsuariosEntity usuario) {
        UsuariosEntity existingUsuario = usuarioService.getUsuarioById(id);
        if (existingUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(usuario, existingUsuario);
        UsuariosEntity updatedUsuario = usuarioService.update(existingUsuario);
        return ResponseEntity.ok(updatedUsuario);
    }
}
