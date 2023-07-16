/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.filmplanet.Repository;

import com.filmplanet.Entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Long>{

    public  UsuariosEntity findByUsername(String username);

    UsuariosEntity findOneByUserid(long userid);
    
}
