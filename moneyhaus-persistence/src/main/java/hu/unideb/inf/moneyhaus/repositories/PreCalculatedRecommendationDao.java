/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.PreCalculatedRecommendationEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Nolbelt
 */
public interface PreCalculatedRecommendationDao extends JpaRepository<PreCalculatedRecommendationEntity, Long>{

    @Query("SELECT p FROM PreCalculatedRecommendationEntity p WHERE p.date in (SELECT max(p.date) FROM PreCalculatedRecommendationEntity p) ORDER BY p.growth DESC")
    public List<PreCalculatedRecommendationEntity> findLatestRecommendations();
    
}
