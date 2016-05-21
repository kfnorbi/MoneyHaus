
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.PreCalculatedRecommendationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * This interface is for getting PreCalculatedRecommendation data from
 * persistence.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PreCalculatedRecommendationDao extends JpaRepository<PreCalculatedRecommendationEntity, Long> {

    /**
     * Returns all the latest recommendations.
     *
     * @return the latest recommendations
     */
    @Query("SELECT p FROM PreCalculatedRecommendationEntity p WHERE p.date in (SELECT max(p.date) FROM PreCalculatedRecommendationEntity p) ORDER BY p.growth DESC")
    public List<PreCalculatedRecommendationEntity> findLatestRecommendations();

}
