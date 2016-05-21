
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.DailyAveragePreCalculated;
import java.util.Date;
import java.util.List;

/**
 *
 * This contains some basic methods for managing previously calculated avarages
 * for a day.
 */
public interface DailyAveragePreCalculatedService {

    /**
     * Saves the daily calculated average specified.
     *
     * @param average the object to be saved
     */
    public void save(DailyAveragePreCalculated average);

    /**
     * Saves the daily calculated averages specified.
     *
     * @param average the objects to be saved
     */
    public void save(List<DailyAveragePreCalculated> average);

    /**
     * Retrieves the daily average currency rates of the currency
     * {@code currency} since date {@code date}.
     *
     * @param currencyCode the currency code needed to be retrieve
     * @param date the day of the calculation
     * @return the average daily currency exchange rate since the date specified
     */
    public List<DailyAveragePreCalculated> findByCurrencyCodeSince(String currencyCode, Date date);

    /**
     * Retrieves the latest daily average currency exchange rate of the currency
     * specified.
     *
     * @param currencyCode the code of the currency
     * @return the daily average currency exchange rate
     */
    public DailyAveragePreCalculated findLatestByCurrencyCode(String currencyCode);

}
