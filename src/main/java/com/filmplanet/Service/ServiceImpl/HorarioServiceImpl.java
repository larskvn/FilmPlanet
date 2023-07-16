package com.filmplanet.Service.ServiceImpl;

import com.filmplanet.Entity.HorarioEntity;
import com.filmplanet.Repository.HorarioRepository;
import com.filmplanet.Service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    HorarioRepository horarioRepository;

    @Override
    public List<HorarioEntity> findAll() {
        return horarioRepository.findAll();
    }

    @Override
    public List<HorarioEntity> findAllCustom() {
        return horarioRepository.findAllCustom();
    }

    @Override
    public Optional<HorarioEntity> findById(long id) {
        return horarioRepository.findById(id);
    }

    @Override
    public HorarioEntity add(HorarioEntity h) {
        return horarioRepository.save(h);
    }

    @Override
    public HorarioEntity update(HorarioEntity h) {
        HorarioEntity horarioExistente = horarioRepository.findById(h.getId())
                .orElseThrow(() -> new NoSuchElementException("Horario no encontrado"));
        horarioExistente.setFecha(h.getFecha());
        horarioExistente.setHora(h.getHora());
        horarioExistente.setPelicula(h.getPelicula());
        horarioExistente.setSala(h.getSala());
        horarioExistente.setPrecio(h.getPrecio());
        return horarioRepository.save(horarioExistente);
    }

    @Override
    public HorarioEntity delete(HorarioEntity h) {
        HorarioEntity objhorario = horarioRepository.getById(h.getId());
        objhorario.setState(false);
        return horarioRepository.save(objhorario);
    }
}
