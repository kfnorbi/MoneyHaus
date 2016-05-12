/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public interface CurrencyBaseConverter {

    public CurrencyRateVO convertTo(CurrencyRateVO from, CurrencyRateVO to);

    public BigDecimal getValue(OwnedCurrency currency, String rate) throws NoCurrencyDataException;

    public BigDecimal getValue(List<OwnedCurrency> currencies, String rate) throws NoCurrencyDataException;

}
