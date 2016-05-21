
package hu.unideb.inf.moneyhaus.refresher;

/**
 * Calculates the average currency rates for a day.
 */
public interface DailyAveragePreCalculatedRefresher {

    /**
     * Retrieves the daily currency exchange rates and calculates the daily
     * average for each one.
     */
    public void refresh();

}
