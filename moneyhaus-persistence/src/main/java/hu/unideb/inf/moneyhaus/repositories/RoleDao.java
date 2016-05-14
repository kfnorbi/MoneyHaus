/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.RoleEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nolbelt
 */
public interface RoleDao extends JpaRepository<RoleEntity, Long>{
    
    public RoleEntity findByValue(String value);
    
}
