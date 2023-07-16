/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filmplanet.Controller;

import com.filmplanet.Entity.CategoriaEntity;
import com.filmplanet.Service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriasericio;

    @GetMapping
    public List<CategoriaEntity> findAll() {
        return categoriasericio.findAll();
    }

    @GetMapping("/Custom")
    public List<CategoriaEntity> findAllCustom() {
        return categoriasericio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaEntity> findById(@PathVariable long id) {
        return categoriasericio.findById(id);
    }

    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c) {
        return categoriasericio.add(c);
    }

    @PutMapping("/{id}")
    public CategoriaEntity update(@PathVariable Long id, @RequestBody CategoriaEntity c) {
        c.setId(id);
        return categoriasericio.update(c);
    }

    @DeleteMapping("/{id}")
    public CategoriaEntity delete(@PathVariable long id) {
        CategoriaEntity objarticulo = new CategoriaEntity();
        objarticulo.setEstado(false);
        return categoriasericio.delete(CategoriaEntity.builder().id(id).build());
    }

}
