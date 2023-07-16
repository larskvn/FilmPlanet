/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Service;

import com.filmplanet.Entity.CategoriaEntity;
import java.util.List;
import java.util.Optional;


public interface CategoriaService {
    
    public List<CategoriaEntity> findAll();

    public List<CategoriaEntity> findAllCustom();

    public Optional<CategoriaEntity> findById(long id);

    public CategoriaEntity add(CategoriaEntity c);

    public CategoriaEntity update(CategoriaEntity c);

    public CategoriaEntity delete(CategoriaEntity c);
}