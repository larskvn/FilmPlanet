package com.filmplanet.Repository;

import com.filmplanet.Entity.ReservacionEntity;
import com.filmplanet.Entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservacionesRepository extends JpaRepository<ReservacionEntity, Long> {
    List<ReservacionEntity> findByUsuario(UsuariosEntity usuario);

}
