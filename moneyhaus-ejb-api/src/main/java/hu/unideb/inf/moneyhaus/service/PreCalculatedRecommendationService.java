package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.util.Date;
import java.util.List;

/**
 *
 * This class' only purpose is to enhance the speed of the recommendation
 * algorithm by determining all of the recommended currencies before a user
 * requests it.
 */
public interface PreCalculatedRecommendationService {

    /**
     * Saves a recommendation.
     *
     * @param preCalculatedRecommendation the recommendation to be saved
     */
    public void save(PreCalculatedRecommendation preCalculatedRecommendation);

    /**
     * Saves recommendations.
     *
     * @param preCalculatedRecommendations the recommendations to be saved
     */
    public void save(List<PreCalculatedRecommendation> preCalculatedRecommendations);

    /**
     * Calculate the recommendations from the exchange rates.
     *
     * @return all of the possible recommended currencies
     * @param date the date proximity of the recommendation Calculations will
     * use currency rates since.
     */
    public List<PreCalculatedRecommendation> calculateRecommendations(Date date);

    /**
     * Retrieves the largest growth recommendations.
     *
     * @return the largest growth recommendations
     */
    public List<PreCalculatedRecommendation> getBiggestRecommendations();

}
