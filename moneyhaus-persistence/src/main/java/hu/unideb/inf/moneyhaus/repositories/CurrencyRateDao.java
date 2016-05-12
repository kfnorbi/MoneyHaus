package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyRateDao extends JpaRepository<CurrencyRate, Long> {

    public List<CurrencyRate> findByCurrencyCodeOrderByDate(String currencyCode);

    @Query("SELECT c FROM CurrencyRate c WHERE c.currencyCode = :#{#currencyCode} AND c.date = :#{#currencyRate.date}")
    public CurrencyRate findCurrencyRateFromTheSameRefresh(String currencyCode, CurrencyRate currencyRate);

    @Query("SELECT c FROM CurrencyRate c WHERE c.date in (SELECT MAX(c.date) FROM CurrencyRate c) AND c.base = ?1)")
    public CurrencyRate findByCurrencyCodeTopOrderByDate(String currencyCode);

//    @Query("select date_base from "
//            + "(SELECT base as date_base,rate FROM moneyhaus.currency_rate where date_of_refresh in (select max(date_of_refresh) from currency_rate)) as date"
//            + "inner join"
//            + "(select base as avg_base,avg(rate) as average from currency_rate where date_of_refresh>subdate(current_date, 1) group by base) as avg on date_base = avg_base order by rate/average limit 20")
//    public List<String> findTheBiggestGrowthCurrencies();
    
    @Query("SELECT new java.lang.String(c.base) FROM CurrencyRate c GROUP BY c.base")
    public List<String> findAllGrouppedByCurrencyCode();
}
