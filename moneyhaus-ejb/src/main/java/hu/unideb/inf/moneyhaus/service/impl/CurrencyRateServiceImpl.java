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
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * This class implements some basic currency rate methods.
 */
@Stateless
@Local(CurrencyRateService.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CurrencyRateServiceImpl implements CurrencyRateService {

    /**
     * CurrencyDao.
     */
    @Autowired
    CurrencyRateDao currencyDao;
    /**
     * Maximum drawn currencies on chart.
     */
    private final int MAXIMUM_REQUESTED_CURRENCIES = 10;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(CurrencyRateVO currency) {
        currencyDao.save(GenericConverter.mapTo(currency, CurrencyRate.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CurrencyRateVO> findByCurrencyBase(String code) {
        return GenericConverter.mapTo(currencyDao.findByBaseOrderByDate(code), CurrencyRateVO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CurrencyRateVO findLatestCurrency(String currencyCode) {
        return GenericConverter.mapTo(currencyDao.findByCurrencyCodeTopOrderByDate(currencyCode), CurrencyRateVO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllManagedCurrencies() {
        return currencyDao.findAllGrouppedByCurrencyCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CurrencyRateVO> findByCurrencyBaseBetweenDates(String code, Date start, Date end) {
        return GenericConverter.mapTo(currencyDao.findCurrencyRateByBaseWhereRefreshDateBetweenDates(code, start, end), CurrencyRateVO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double findAverageOnDay(String currency, Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return currencyDao.findAvaragesByCurrencyCodeSince(currency,
                Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(localDate.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double findAverageOfCurrencySinceDate(String currencyCode, Date date) {
        return currencyDao.findAvaragesByCurrencyCodeSince(currencyCode, date, new Date());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(List<CurrencyRateVO> currencies) {
        for (CurrencyRateVO c : currencies) {
            save(c);
        }
    }

}
