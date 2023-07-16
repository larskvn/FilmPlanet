package com.filmplanet.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservacionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity usuario;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private HorarioEntity horario;

    @Column(name = "fechaReservacion")
    private LocalDateTime fechaReservacion;
}
