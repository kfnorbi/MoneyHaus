/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.OwnedCurrenciesEntity;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nolbelt
 */
@Repository
public interface OwnedCurrencyDao extends JpaRepository<OwnedCurrenciesEntity,Long>{
    
    public List<OwnedCurrenciesEntity> findByUser(UserEntity user);
    
}
