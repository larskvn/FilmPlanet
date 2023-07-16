
package com.filmplanet.Controller;

import com.filmplanet.Entity.PeliculasEntity;
import com.filmplanet.Service.PeliculaService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaservicio;

    @GetMapping
    public List<PeliculasEntity> findAll() {
        return peliculaservicio.findAll();
    }

    @GetMapping("/Custom")
    public List<PeliculasEntity> findAllCustom() {
        return peliculaservicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<PeliculasEntity> findById(@PathVariable long id) {
        return peliculaservicio.findById(id);
    }

    @PostMapping
    public PeliculasEntity add(@RequestBody PeliculasEntity p) {
        return peliculaservicio.add(p);
    }

    @PutMapping("/{id}")
    public PeliculasEntity update(@PathVariable Long id, @RequestBody PeliculasEntity p) {
        p.setId(id);
        return peliculaservicio.update(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        PeliculasEntity pelicula = peliculaservicio.delete(id);

        if (pelicula != null) {
            return ResponseEntity.ok("La película ha sido eliminada.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
