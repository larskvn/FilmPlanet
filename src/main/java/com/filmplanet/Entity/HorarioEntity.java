/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity(name = "HorarioEntity")
@Table(name = "horarios")
public class HorarioEntity {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private String hora;
    private String sala;
    private double precio;
    private Boolean state=true;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private PeliculasEntity pelicula;

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

 public String getHora() {
  return hora;
 }

 public void setHora(String hora) {
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
}
