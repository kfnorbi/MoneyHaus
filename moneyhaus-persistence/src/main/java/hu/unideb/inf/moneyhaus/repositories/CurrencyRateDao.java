package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface contains basic operations for managing currency rates.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CurrencyRateDao extends JpaRepository<CurrencyRate, Long> {

    /**
     *
     * Returns all the currency rates which base is {@code currencyCode} ordered
     * by the date of its refresh.
     *
     * @param base the currency needed
     * @return all the currency rates which base is {@code currencyCode} ordered
     * by the date of its refresh <br> If none found returns an empty
     * {@link java.util.List list}.
     */
    public List<CurrencyRate> findByBaseOrderByDate(String base);

    /**
     * Returns the latest exchange rate of {@code currencyCode}.
     *
     * @param currencyCode the code of the currency needed
     * @return the latest exchange rate of {@code currencyCode}
     */
    @Query("SELECT c FROM CurrencyRate c WHERE c.date in (SELECT MAX(c.date) FROM CurrencyRate c WHERE c.base = :currencyCode) AND c.base = :currencyCode)")
    public CurrencyRate findByCurrencyCodeTopOrderByDate(@Param("currencyCode") String currencyCode);

    /**
     *
     * Returns all the currency codes ever managed.
     *
     * @return {@link java.util.List List} of the currencies ever managed.
     */
    @Query("SELECT new java.lang.String(c.base) FROM CurrencyRate c GROUP BY c.base")
    public List<String> findAllGrouppedByCurrencyCode();

    /**
     *
     * Returns the currency rates of {@code base} between {@code start} and
     * {@code end}.
     *
     * @param base the base of the currency
     * @param start the start of the period needed
     * @param end the end of the period needed
     * @return {@link java.util.List List} of the currency exchange rates of
     * {@code base} between {@code start} and {@code end}
     */
    @Query("SELECT c FROM CurrencyRate c WHERE c.base = :base AND c.date BETWEEN :start AND :end")
    public List<CurrencyRate> findCurrencyRateByBaseWhereRefreshDateBetweenDates(@Param("base") String base, @Param("start") Date start, @Param("end") Date end);

    /**
     * Returns all the latest currency exchange rates.
     *
     * @return the lates currency exchange rates
     */
    @Query("SELECT c FROM CurrencyRate c WHERE c.date in (SELECT MAX(c.date) FROM CurrencyRate c))")
    public List<CurrencyRate> findLatestCurrencies();

    /**
     *
     * Returns the average currency exchange rate of {@code currency} between
     * {@code start} and {@code end}.
     *
     * @param currency the currency code needed
     * @param start the start of the period
     * @param end the end of the period
     * @return the average currency exchange rate
     */
    @Query("SELECT avg(c.rate) FROM CurrencyRate c WHERE c.base = :currency AND c.date BETWEEN :start AND :end")
    public Double findAvaragesByCurrencyCodeSince(@Param("currency") String currency, @Param("start") Date start, @Param("end") Date end);

}
