package com.filmplanet.Controller;

import com.filmplanet.Entity.ActorEntity;
import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Entity.PeliculasEntity;
import com.filmplanet.Service.ActorService;
import com.filmplanet.Service.HorarioService;
import com.filmplanet.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ActorService actorservicio;
    @Autowired
    HorarioService horarioService;

    @Autowired
    private PeliculaService peliculaservicio;


    @GetMapping("/actor-na/Custom")
    public List<ActorEntity> findAllCustomActor() {
        return actorservicio.findAllCustom();
    }


    @GetMapping("/horario-na/Custom")
    public List<HorarioEntity> findAllCustomHorario(){
        return horarioService.findAllCustom();
    }



    @GetMapping("/pelicula-na/Custom")
    public List<PeliculasEntity> findAllCustomPelicula() {
        return peliculaservicio.findAllCustom();
    }
}
