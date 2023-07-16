package com.filmplanet.Service;

import com.filmplanet.Entity.UsuariosEntity;

import java.util.List;
import java.util.Map;

public interface UsuarioService {
    public UsuariosEntity save(UsuariosEntity usuario) throws Exception;

    public List<UsuariosEntity> findAll();

    public  UsuariosEntity obtenerUser(String username);

    public UsuariosEntity getUsuarioById(long userid);

    public UsuariosEntity delete(UsuariosEntity u);

    public UsuariosEntity update(UsuariosEntity u);

}
