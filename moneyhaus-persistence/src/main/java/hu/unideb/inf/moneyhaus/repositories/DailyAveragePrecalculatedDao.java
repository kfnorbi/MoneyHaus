
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.DailyAveragePreCalculatedEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface is for getting DailyAveragePrecalculated object from
 * persistence.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface DailyAveragePrecalculatedDao extends JpaRepository<DailyAveragePreCalculatedEntity, Long> {

    /**
     * Returns the latest average currency exchange rate of
     * {@code currencyCode}.
     *
     * @param currencyCode the currency code needed
     * @return the lates average currency exchange rate
     */
    @Query("SELECT d FROM DailyAveragePreCalculatedEntity d WHERE d.date in (SELECT max(d.date) FROM DailyAveragePreCalculatedEntity d) AND d.currencyCode = :currencyCode")
    DailyAveragePreCalculatedEntity findLatestByCode(@Param("currencyCode") String currencyCode);

    /**
     * Returns the average currency exchange rates of {@code currencyCode}
     * between {@code start} and {@code end}.
     *
     * @param currencyCode the currency code of the average needed
     * @param start the start of the period
     * @param end the end of the period
     * @return all the average currency exchange rate between {@code start} and
     * {@code end}.
     */
    @Query("SELECT d FROM DailyAveragePreCalculatedEntity d WHERE d.currencyCode = :currencyCode AND d.date BETWEEN :start AND :end order by d.date")
    List<DailyAveragePreCalculatedEntity> findByCurrencyCodeBetweenDate(@Param("currencyCode") String currencyCode, @Param("start") Date start, @Param("end") Date end);

}
