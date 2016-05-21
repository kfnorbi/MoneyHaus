package hu.unideb.inf.moneyhaus.refresher;

import hu.unideb.inf.moneyhaus.service.PreCalculatedRecommendationService;
import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * This class reads currency rates from the database and calculates if the the
 * latest currency is greater than the average of the last day's.
 */
@Stateless(mappedName = "preCalculatedRecommendationRefresher")
@Remote(PreCalculatedRecommendationRefresher.class)
public class PreCalculatedRecommendationRefresherImpl implements PreCalculatedRecommendationRefresher {

    /**
     * PreCalculatedRecommendationService.
     */
    @EJB
    PreCalculatedRecommendationService preCalculatedRecommendationService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() {
        List<PreCalculatedRecommendation> result = preCalculatedRecommendationService.calculateRecommendations();
        preCalculatedRecommendationService.save(result);
    }

}
