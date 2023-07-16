package com.filmplanet.Service;

import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Entity.PeliculasEntity;

import java.util.List;
import java.util.Optional;

public interface HorarioService {

    public List<HorarioEntity> findAll();

    public List<HorarioEntity> findAllCustom();

    public Optional<HorarioEntity> findById(long id);

    public HorarioEntity add(HorarioEntity h);

    public HorarioEntity update(HorarioEntity h);

    public HorarioEntity delete(HorarioEntity h);
}
