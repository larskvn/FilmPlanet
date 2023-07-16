package com.filmplanet.Service;

import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Entity.ReservacionEntity;
import com.filmplanet.Entity.UsuariosEntity;

import java.util.List;

public interface ReservacionService {
    public List<ReservacionEntity> findAll();

    public List<ReservacionEntity> findReservacionesByUsuario(UsuariosEntity usuario);
    public ReservacionEntity createReservacion(UsuariosEntity usuario, HorarioEntity horario);


    public void deleteReservacion(Long id);
}
