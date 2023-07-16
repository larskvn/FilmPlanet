/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Controller;

import com.filmplanet.Entity.ActorEntity;
import com.filmplanet.Service.ActorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorservicio;

    @GetMapping
    public List<ActorEntity> findAll() {
        return actorservicio.findAll();
    }

    @GetMapping("/Custom")
    public List<ActorEntity> findAllCustom() {
        return actorservicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public  Optional<ActorEntity> findById(@PathVariable long id){
        return actorservicio.findById(id);
    }
    
    @PostMapping
    public ActorEntity add(@RequestBody ActorEntity a){
        return actorservicio.add(a);
    }
    
    @PutMapping("/{id}")
     public ActorEntity update(@PathVariable Long id, @RequestBody ActorEntity a) {
        a.setId(id);
        return actorservicio.update(a);
    }
    
     @DeleteMapping("/{id}")
     public ActorEntity delete(@PathVariable long id) {
        ActorEntity objarticulo = new ActorEntity();
        objarticulo.setEstado(false);
        return actorservicio.delete(ActorEntity.builder().id(id).build());
    }

}
