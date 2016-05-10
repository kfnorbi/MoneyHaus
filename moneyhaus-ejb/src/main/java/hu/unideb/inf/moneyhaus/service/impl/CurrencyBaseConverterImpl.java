/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service.impl;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import hu.unideb.inf.moneyhaus.repositories.CurrencyRateDao;
import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Currency;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author Nolbelt
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class CurrencyBaseConverterImpl {

    @Autowired
    CurrencyRateDao currencyRateDao;

    
    private CurrencyRateVO findNewBase(Currency currency, CurrencyRateVO newBase) throws NoCurrencyDataException {
        CurrencyRate rate = GenericConverter.mapTo(currency, CurrencyRate.class);
        CurrencyRate newBaseEntity = currencyRateDao.findCurrencyRateFromTheSameRefresh(newBase.getCurrencyCode(), rate);
        if (newBaseEntity == null) {
            throw new NoCurrencyDataException("Our database does not contain information about " + currency.getCurrencyCode() + " at " + newBase.getDateTime());
        }
        return GenericConverter.mapTo(newBaseEntity, CurrencyRateVO.class);
    }
    
    
    public CurrencyRateVO convertTo(CurrencyRateVO currency, Currency newBase)  throws NoCurrencyDataException {
        CurrencyRateVO newBaseVO = findNewBase(newBase, currency);
        
        //TODO conversion
        return null;
    }

    public List<CurrencyRateVO> convertTo(List<CurrencyRateVO> currencies, Currency newBase) throws NoCurrencyDataException {
        //TODO oonversion
        return null;
    }
}
