/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Service.ServiceImpl;

import com.filmplanet.Entity.ActorEntity;
import com.filmplanet.Repository.ActorRepository;
import java.util.List;
import java.util.Optional;

import com.filmplanet.Service.ActorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImp implements ActorService {
    
    @Autowired
    private ActorRepository actorepositorio;

    @Override
    public List<ActorEntity> findAll() {
        return actorepositorio.findAll();
    }

    @Override
    public List<ActorEntity> findAllCustom() {
        return  actorepositorio.findAllCustom();
    }

    @Override
    public Optional<ActorEntity> findById(long id) {
        return actorepositorio.findById(id);
    }

    @Override
    public ActorEntity add(ActorEntity a) {
        return actorepositorio.save(a);
    }

    @Override
    public ActorEntity update(ActorEntity a) {
        ActorEntity objactor = actorepositorio.getById(a.getId());
        BeanUtils.copyProperties(a, objactor);
        return  actorepositorio.save(objactor);
    }

    @Override
    public ActorEntity delete(ActorEntity a) {
        ActorEntity objactor = actorepositorio.getById(a.getId());
        objactor.setEstado(false);
        return actorepositorio.save(objactor);
    }
    
}
