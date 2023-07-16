/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Repository;

import com.filmplanet.Entity.CategoriaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    @Query(value = "SELECT * FROM CategoriaEntity WHERE estado = '1'", nativeQuery = true)
    List<CategoriaEntity> findAllCustom();
}
