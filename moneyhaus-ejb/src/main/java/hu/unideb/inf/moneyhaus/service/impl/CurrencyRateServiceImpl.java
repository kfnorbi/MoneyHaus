package hu.unideb.inf.moneyhaus.service.impl;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import hu.unideb.inf.moneyhaus.repositories.CurrencyRateDao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.exception.CurrencyOverloadException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(CurrencyRateService.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CurrencyRateServiceImpl implements CurrencyRateService {

    @Autowired
    CurrencyRateDao currencyDao;
    private final int MAXIMUM_REQUESTED_CURRENCIES = 10;

    @Override
    public void save(CurrencyRateVO currency) {
        currencyDao.save(GenericConverter.mapTo(currency, CurrencyRate.class));
    }

    @Override
    public List<CurrencyRateVO> findByCurrencyBase(String code) {
        return GenericConverter.mapTo(currencyDao.findByBaseOrderByDate(code), CurrencyRateVO.class);
    }

    @Override
    public Map<Currency, List<CurrencyRateVO>> findCurrenciesByCode(List<Currency> currencies) throws CurrencyOverloadException {
        if (currencies.size() > MAXIMUM_REQUESTED_CURRENCIES) {
            throw new CurrencyOverloadException("The requested currency quantity cannot be over " + MAXIMUM_REQUESTED_CURRENCIES);
        }
        Map<Currency, List<CurrencyRateVO>> rates = new HashMap<>();
        for (Currency c : currencies) {
            rates.put(c, GenericConverter.mapTo(currencyDao.findByBaseOrderByDate(c.getCurrencyCode()), CurrencyRateVO.class));
        }
        return rates;
    }

    @Override
    public CurrencyRateVO findLatestCurrency(String currencyCode) {
        return GenericConverter.mapTo(currencyDao.findByCurrencyCodeTopOrderByDate(currencyCode), CurrencyRateVO.class);
    }

    @Override
    public List<String> getAllManagedCurrencies() {
        return currencyDao.findAllGrouppedByCurrencyCode();
    }

    @Override
    public List<CurrencyRateVO> findByCurrencyBaseBetweenDates(String code, Date start, Date end) {
        return GenericConverter.mapTo(currencyDao.findCurrencyRateByBaseWhereRefreshDateBetweenDates(code, start, end), CurrencyRateVO.class);
    }

    @Override
    public Double findAverageOnDay(String currency, Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return currencyDao.findAvaragesByCurrencyCodeSince(currency, 
                Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
                Date.from(localDate.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Override
    public Double findAverageOfCurrencySinceDate(String currencyCode, Date date) {
        return currencyDao.findAvaragesByCurrencyCodeSince(currencyCode, date, new Date());
    }


}
