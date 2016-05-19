/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.DailyAveragePreCalculatedEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nolbelt
 */
@Repository
public interface DailyAveragePrecalculatedDao  extends JpaRepository<DailyAveragePreCalculatedEntity, Long>{
    
    @Query("SELECT d FROM DailyAveragePreCalculatedEntity d WHERE d.date in (SELECT max(d.date) FROM DailyAveragePreCalculatedEntity d) AND d.currencyCode = :currencyCode")
    DailyAveragePreCalculatedEntity findLatestByCode(@Param("currencyCode")String currencyCode);
    
    @Query("SELECT d FROM DailyAveragePreCalculatedEntity d WHERE d.currencyCode = :currencyCode AND d.date BETWEEN :start AND :end")
    List<DailyAveragePreCalculatedEntity> findByCurrencyCodeBetweenDate(@Param("currencyCode")String currencyCode,@Param("start")Date start,@Param("end")Date end);
    
}
