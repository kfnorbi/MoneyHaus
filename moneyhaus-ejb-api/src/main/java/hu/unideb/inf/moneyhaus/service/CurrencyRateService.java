package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.service.exception.CurrencyOverloadException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CurrencyRateService {

	public void save(CurrencyRateVO currency);
	
        public List<CurrencyRateVO> findByCurrencyBase(String code);
        
        public Map<Currency,List<CurrencyRateVO>> findCurrenciesByCode(List<Currency> currencies) throws CurrencyOverloadException;
        
        public CurrencyRateVO findLatestCurrency(String currencyCode);
                
        public List<String> getAllManagedCurrencies();
                
        public List<CurrencyRateVO> findByCurrencyBaseBetweenDates(String code,Date start,Date end);
        
        public Double findAverageOnDay(String currency,Date date);
        
        public Double findAverageOfCurrencySinceDate(String currencyCode,Date date);
}
