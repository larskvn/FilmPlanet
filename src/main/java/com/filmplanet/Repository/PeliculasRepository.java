/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Repository;


import com.filmplanet.Entity.PeliculasEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository extends JpaRepository<PeliculasEntity, Long> {
     @Query(value = "SELECT * FROM pelicula WHERE estado = '1'", nativeQuery = true)
     List<PeliculasEntity> findAllCustom();
}
