package com.filmplanet.Service.ServiceImpl;

import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Repository.UsuarioRepository;
import com.filmplanet.Service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuariosEntity save(UsuariosEntity usuario) throws Exception {
        String username = usuario.getUsername();
        UsuariosEntity usuarioExistente = usuarioRepository.findByUsername(username);
        if (usuarioExistente != null) {
            System.out.println("Usuario ya está registrado");
            throw new Exception("Usuario ya está presente");
        }

        // Si no hay un usuario existente con el mismo atributo único, guardamos el nuevo usuario
        UsuariosEntity usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioGuardado;
    }

    @Override
    public List<UsuariosEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuariosEntity obtenerUser(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UsuariosEntity getUsuarioById(long userid) {
        return usuarioRepository.findById(userid).orElse(null);
    }

    @Override
    public UsuariosEntity delete(UsuariosEntity u) {
        UsuariosEntity usuarioEntity = usuarioRepository.getById(u.getUserid());
        usuarioEntity.setEnable(false);
        return usuarioRepository.save(usuarioEntity);
    }

    @Override
    public UsuariosEntity update(UsuariosEntity u) {
        UsuariosEntity objpaciente = usuarioRepository.getById(u.getUserid());
        BeanUtils.copyProperties(u,objpaciente);
        return usuarioRepository.save(objpaciente);
    }
}
