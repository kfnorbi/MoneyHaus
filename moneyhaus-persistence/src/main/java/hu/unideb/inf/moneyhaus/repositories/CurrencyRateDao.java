package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyRateDao extends JpaRepository<CurrencyRate, Long> {

    public List<CurrencyRate> findByCurrencyCodeOrderByDate(String currencyCode);
    
    @Query("SELECT c FROM CurrencyRate c WHERE c.currencyCode = :#{#currencyCode} AND c.date = :#{#currencyRate.date}")
    public CurrencyRate findCurrencyRateFromTheSameRefresh(String currencyCode,CurrencyRate currencyRate);
    
}
