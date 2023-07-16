package com.filmplanet.Repository;

import com.filmplanet.Entity.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioRepository extends JpaRepository<HorarioEntity,Long> {

    @Query("select m from HorarioEntity m where m.state='1'")
    List<HorarioEntity> findAllCustom();

}
