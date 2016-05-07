package hu.unideb.inf.moneyhaus.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(CurrencyRateService.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CurrencyRateServiceImpl implements CurrencyRateService {

    @Autowired
    CurrencyRateService currencyRateService;

    @Override
    public void save(CurrencyRateVO currency) {
        currencyRateService.save(currency);
    }

}
