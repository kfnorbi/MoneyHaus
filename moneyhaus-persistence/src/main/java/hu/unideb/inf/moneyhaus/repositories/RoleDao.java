/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.RoleEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface is for getting Role objects from persistence.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface RoleDao extends JpaRepository<RoleEntity, Long> {

    /**
     * Returns a role holding {@code value}.
     *
     * @param value the role with value needed
     * @return the role representing role {@code value}
     */
    public RoleEntity findByValue(String value);

}
