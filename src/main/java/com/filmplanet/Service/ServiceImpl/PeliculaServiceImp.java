/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Service.ServiceImpl;

import com.filmplanet.Entity.PeliculasEntity;
import com.filmplanet.Repository.PeliculasRepository;
import java.util.List;
import java.util.Optional;

import com.filmplanet.Service.PeliculaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImp implements PeliculaService {

    @Autowired
    private PeliculasRepository pelicularepositorio;

    @Override
    public List<PeliculasEntity> findAll() {
        return pelicularepositorio.findAll();
    }

    @Override
    public List<PeliculasEntity> findAllCustom() {
        return pelicularepositorio.findAllCustom();
    }

    @Override
    public Optional<PeliculasEntity> findById(long id) {
        return pelicularepositorio.findById(id);
    }

    @Override
    public PeliculasEntity add(PeliculasEntity p) {
        return pelicularepositorio.save(p);
    }

    @Override
    public PeliculasEntity update(PeliculasEntity p) {
        PeliculasEntity objpelicula = pelicularepositorio.getById(p.getId());
        BeanUtils.copyProperties(p, objpelicula);
        return pelicularepositorio.save(objpelicula);
    }

    @Override
    public PeliculasEntity delete(Long id) {
        Optional<PeliculasEntity> peliculaOptional = pelicularepositorio.findById(id);

        if (peliculaOptional.isPresent()) {
            PeliculasEntity pelicula = peliculaOptional.get();
            pelicula.setEstado(false);
            return pelicularepositorio.save(pelicula);
        } else {
            return null;
        }
    }

}
