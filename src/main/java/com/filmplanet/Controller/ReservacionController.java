package com.filmplanet.Controller;

import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Entity.ReservacionEntity;
import com.filmplanet.Entity.UsuariosEntity;
import com.filmplanet.Service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/reservacion")
public class ReservacionController {
    @Autowired
    ReservacionService reservacionService;
    @GetMapping
    public List<ReservacionEntity>findAll(){
        return reservacionService.findAll();
    }

    @GetMapping("/reservaUser")
    public List<ReservacionEntity> findAll(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return Collections.emptyList();
        }
        UsuariosEntity usuario = (UsuariosEntity) authentication.getPrincipal();
        List<ReservacionEntity> reservas = reservacionService.findReservacionesByUsuario(usuario);
        return reservas;
    }


    @PostMapping
    public ResponseEntity<String> createReservacion(Authentication authentication, @RequestBody HorarioEntity horario) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no autenticado");
        }
        UsuariosEntity usuario = (UsuariosEntity) authentication.getPrincipal();
        ReservacionEntity reservacion = reservacionService.createReservacion(usuario, horario);
        return ResponseEntity.ok("Reserva creada correctamente");
    }
    @DeleteMapping("/{id}")
    public void deleteReservacion(@PathVariable Long id) {
        reservacionService.deleteReservacion(id);
    }

}
