/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Service;

import com.filmplanet.Entity.ActorEntity;
import java.util.List;
import java.util.Optional;


public interface ActorService {
    
    public List<ActorEntity> findAll();
    
    public List<ActorEntity> findAllCustom();
    
    public Optional<ActorEntity> findById(long id);
    
    public ActorEntity add(ActorEntity a);
    public ActorEntity update(ActorEntity a);
    
    public ActorEntity delete(ActorEntity a);
    
            
            
}
