
package hu.unideb.inf.moneyhaus.refresher;

/**
 * Retrieves currency exchange rates from a specific period and decides whether
 * it is recommended or not.
 */
public interface PreCalculatedRecommendationRefresher {

    /**
     * Recalculates the recommended currency rates.
     */
    public void refresh();

}
