package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CurrencyRateDao extends JpaRepository<CurrencyRate, Long> {

    public List<CurrencyRate> findByBaseOrderByDate(String currencyCode);

    @Query("SELECT c FROM CurrencyRate c WHERE c.date in (SELECT MAX(c.date) FROM CurrencyRate c WHERE c.base = :currencyCode) AND c.base = :currencyCode)")
    public CurrencyRate findByCurrencyCodeTopOrderByDate(@Param("currencyCode") String currencyCode);

    @Query("SELECT new java.lang.String(c.base) FROM CurrencyRate c GROUP BY c.base")
    public List<String> findAllGrouppedByCurrencyCode();

    @Query("SELECT c FROM CurrencyRate c WHERE c.base = :base AND c.date BETWEEN :start AND :end")
    public List<CurrencyRate> findCurrencyRateByBaseWhereRefreshDateBetweenDates(@Param("base") String base, @Param("start") Date start, @Param("end") Date end);

    @Query("SELECT c FROM CurrencyRate c WHERE c.date in (SELECT MAX(c.date) FROM CurrencyRate c))")
    public List<CurrencyRate> findLatestCurrencies();

    @Query("SELECT avg(c.rate) FROM CurrencyRate c WHERE c.base = :currency AND c.date BETWEEN :start AND :end")
    public Double findAvaragesByCurrencyCodeSince(@Param("currency") String currency, @Param("start") Date start, @Param("end") Date end);

}
