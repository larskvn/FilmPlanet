/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Repository;

import com.filmplanet.Entity.ActorEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long>{
    @Query(value = "SELECT * FROM ActorEntity WHERE estado = '1'", nativeQuery = true)
    List<ActorEntity> findAllCustom();
   
    
}
