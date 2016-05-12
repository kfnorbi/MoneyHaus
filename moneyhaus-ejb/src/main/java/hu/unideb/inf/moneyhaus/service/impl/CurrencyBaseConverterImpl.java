package hu.unideb.inf.moneyhaus.service.impl;

import hu.unideb.inf.moneyhaus.service.CurrencyBaseConverter;
import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nolbelt
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CurrencyBaseConverterImpl implements CurrencyBaseConverter {

    @EJB
    CurrencyRateService currencyRateService;

    @Override
    public CurrencyRateVO convertTo(CurrencyRateVO from, CurrencyRateVO to) {
        CurrencyRateVO rate = new CurrencyRateVO();
        rate.setBase(from.getBase());
        rate.setCurrencyCode(to.getBase());
        rate.setRate(from.getRate().divide(to.getRate(),RoundingMode.HALF_UP));
        return rate;
    }

    @Override
    public BigDecimal getValue(OwnedCurrency currency, String rate) throws NoCurrencyDataException {
        CurrencyRateVO expected = currencyRateService.findLatestCurrency(rate);

        CurrencyRateVO actual = currencyRateService.findLatestCurrency(currency.getCurrency());
        if (expected == null || actual == null){
            throw new NoCurrencyDataException("Some currencies are not supported right now");
        }
        CurrencyRateVO convertable = convertTo(actual, expected);
        return currency.getQuantity().multiply(convertable.getRate());
    }

    @Override
    public BigDecimal getValue(List<OwnedCurrency> currencies, String rate) throws NoCurrencyDataException {
        BigDecimal result = BigDecimal.ZERO;
        for (OwnedCurrency currency : currencies) {
                result = result.add(getValue(currency, rate));
        }
        return result;
    }

}
