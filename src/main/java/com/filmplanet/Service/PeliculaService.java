/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Service;


import com.filmplanet.Entity.PeliculasEntity;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    public List<PeliculasEntity> findAll();

    public List<PeliculasEntity> findAllCustom();

    public Optional<PeliculasEntity> findById(long id);

    public PeliculasEntity add(PeliculasEntity p);

    public PeliculasEntity update(PeliculasEntity p);

    public PeliculasEntity delete(Long id);

}
