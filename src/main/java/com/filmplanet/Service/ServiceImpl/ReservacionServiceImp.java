package com.filmplanet.Service.ServiceImpl;

import com.filmplanet.Entity.ActorEntity;
import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Entity.ReservacionEntity;
import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Repository.ReservacionesRepository;
import com.filmplanet.Service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservacionServiceImp implements ReservacionService {

    @Autowired
    ReservacionesRepository reservacionesRepository;
    @Override
    public List<ReservacionEntity> findAll(){
        return reservacionesRepository.findAll();
    }

    @Override
    public List<ReservacionEntity> findReservacionesByUsuario(UsuariosEntity usuario) {
        // Realizar la lógica para buscar las reservas por usuario
        return reservacionesRepository.findByUsuario(usuario);
    }

    @Override
    public ReservacionEntity createReservacion(UsuariosEntity usuario, HorarioEntity horario) {
        ReservacionEntity reservacion = new ReservacionEntity();
        reservacion.setUsuario(usuario);
        reservacion.setHorario(horario);
        reservacion.setFechaReservacion(LocalDateTime.now());

        // Guarda la reserva en la base de datos
        return reservacionesRepository.save(reservacion);
    }

    public void deleteReservacion(Long id) {
        ReservacionEntity reservacion = reservacionesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reservación no encontrada"));
        reservacionesRepository.delete(reservacion);
    }
}
