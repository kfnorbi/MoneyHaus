package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.service.exception.CurrencyOverloadException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Currency;
import java.util.List;
import java.util.Map;

public interface CurrencyRateService {

	public void save(CurrencyRateVO currency);
	
        public List<CurrencyRateVO> findByCurrencyCode(String code);
        
        public Map<Currency,List<CurrencyRateVO>> findCurrenciesByCode(List<Currency> currencies) throws CurrencyOverloadException;
        
        public CurrencyRateVO findLatestCurrency(String currencyCode);
        
        public List<String> findTheBiggestGrowthCurrencies();
        
        public List<String> getAllManagedCurrencies();
        
}
