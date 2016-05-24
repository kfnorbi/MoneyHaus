package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Date;
import java.util.List;

/**
 *
 * This contains some basic methods for managing currency rates.
 */
public interface CurrencyRateService {

    /**
     * Saves a currency rate.
     *
     * @param currency the currency rate to be saved
     */
    public void save(CurrencyRateVO currency);
    
    /**
     * Saves a currency rates.
     *
     * @param currencies the currency rates to be saved
     */
    public void save(List<CurrencyRateVO> currencies);

    /**
     * Retrieves all the {@code code} currencies.
     *
     * @param code the currency code of the currency rates needed
     * @return the currency rates of {@code code} <br> Returns empty list if
     * none found.
     */
    public List<CurrencyRateVO> findByCurrencyBase(String code);

    /**
     * Retrieves the latest {@code currencyCode} currencies.
     *
     * @param currencyCode the currency code needed
     * @return the latest currency exchange rate of the currency
     * {@code currencyCode} <br> Returns null if none found.
     */
    public CurrencyRateVO findLatestCurrency(String currencyCode);

    /**
     * Returns all of the currency codes ever managed.
     *
     * @return the currency codes of all the managed currencies
     */
    public List<String> getAllManagedCurrencies();

    /**
     * Returns the currency exchange rates of {@code code} in the period between
     * {@code start} and {@code end}.
     *
     * @param code the currency code to find by
     * @param start the start of the period
     * @param end the end of the period
     * @return the currncy rates of {@code code} between {@code start} and
     * {@code end}
     */
    public List<CurrencyRateVO> findByCurrencyBaseBetweenDates(String code, Date start, Date end);

    /**
     * Retrieves the avarage currency rate of the currency {@code currency} on
     * the day of {@code date}.
     *
     * @param currency the currency code of the currency needed
     * @param date the day of the average calculation
     * @return the average currency exchange rate
     */
    public Double findAverageOnDay(String currency, Date date);

    /**
     * Retrieves the average currency exchange rates of the currency
     * {@code currency} since {@code date}.
     *
     * @param currencyCode the code of the currency needed
     * @param date the date of the average needed since
     * @return the average of the currency exchange rates since the specified
     * date
     */
    public Double findAverageOfCurrencySinceDate(String currencyCode, Date date);
}
