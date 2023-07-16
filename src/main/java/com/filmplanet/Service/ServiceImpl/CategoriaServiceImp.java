/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Service.ServiceImpl;

import com.filmplanet.Entity.CategoriaEntity;
import com.filmplanet.Repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

import com.filmplanet.Service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements CategoriaService {

    
    @Autowired
    private CategoriaRepository categoriarepositorio;
    
    @Override
    public List<CategoriaEntity> findAll() {
        return categoriarepositorio.findAll();
    }

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return categoriarepositorio.findAllCustom();
    }

    @Override
    public Optional<CategoriaEntity> findById(long id) {
        return  categoriarepositorio.findById(id);
    }

    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return categoriarepositorio.save(c);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objcategoria = categoriarepositorio.getById(c.getId());
        BeanUtils.copyProperties(c, objcategoria);
        return categoriarepositorio.save(objcategoria);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity p) {
       CategoriaEntity objcategoria = categoriarepositorio.getById(p.getId());
       objcategoria.setEstado(false);
       return categoriarepositorio.save(objcategoria);
    }
    
}
