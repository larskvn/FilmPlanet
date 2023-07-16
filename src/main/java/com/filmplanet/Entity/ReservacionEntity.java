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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public HorarioEntity getHorario() {
        return horario;
    }

    public void setHorario(HorarioEntity horario) {
        this.horario = horario;
    }

    public LocalDateTime getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(LocalDateTime fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public ReservacionEntity(Long id, UsuariosEntity usuario, HorarioEntity horario, LocalDateTime fechaReservacion) {
        this.id = id;
        this.usuario = usuario;
        this.horario = horario;
        this.fechaReservacion = fechaReservacion;
    }

    public ReservacionEntity() {
    }
}
