/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "HorarioEntity")
@Table(name = "horarios")
public class HorarioEntity {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private LocalTime hora;
    private String sala;
    private double precio;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private PeliculasEntity pelicula;
    @OneToMany(mappedBy = "horario")
    private List<ReservacionEntity> reservaciones = new ArrayList<>();

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public LocalDate getFecha() {
  return fecha;
 }

 public void setFecha(LocalDate fecha) {
  this.fecha = fecha;
 }

 public LocalTime getHora() {
  return hora;
 }

 public void setHora(LocalTime hora) {
  this.hora = hora;
 }

 public String getSala() {
  return sala;
 }

 public void setSala(String sala) {
  this.sala = sala;
 }

 public double getPrecio() {
  return precio;
 }

 public void setPrecio(double precio) {
  this.precio = precio;
 }

 public Boolean getState() {
  return state;
 }

 public void setState(Boolean state) {
  this.state = state;
 }

 public PeliculasEntity getPelicula() {
  return pelicula;
 }

 public void setPelicula(PeliculasEntity pelicula) {
  this.pelicula = pelicula;
 }

 public List<ReservacionEntity> getReservaciones() {
  return reservaciones;
 }

 public void setReservaciones(List<ReservacionEntity> reservaciones) {
  this.reservaciones = reservaciones;
 }

 public HorarioEntity(Long id, LocalDate fecha, LocalTime hora, String sala, double precio, Boolean state, PeliculasEntity pelicula, List<ReservacionEntity> reservaciones) {
  this.id = id;
  this.fecha = fecha;
  this.hora = hora;
  this.sala = sala;
  this.precio = precio;
  this.state = state;
  this.pelicula = pelicula;
  this.reservaciones = reservaciones;
 }

 public HorarioEntity() {
 }
}
