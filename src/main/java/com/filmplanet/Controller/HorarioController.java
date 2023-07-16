package com.filmplanet.Controller;

import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<HorarioEntity> getAllHorarios() {
        return horarioService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<HorarioEntity> findById(@PathVariable Long id){
        return horarioService.findById(id);
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public HorarioEntity add(@RequestBody HorarioEntity horario){
        return horarioService.add(horario);
    }
    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public HorarioEntity update(@PathVariable Long id, @RequestBody HorarioEntity horario){
        horario.setId(id);
        return horarioService.update(horario);

    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HorarioEntity delete(@PathVariable Long id){
        HorarioEntity horarioExistente = horarioService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Horario no encontrado"));
        horarioExistente.setState(false);
        return horarioService.delete(horarioExistente);
    }

}
