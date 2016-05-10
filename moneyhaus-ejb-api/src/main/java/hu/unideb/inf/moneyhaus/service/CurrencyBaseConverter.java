/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Currency;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public interface CurrencyBaseConverter {
    
    public CurrencyRateVO convertTo(CurrencyRateVO currency,Currency newBase) throws NoCurrencyDataException;
    
    public List<CurrencyRateVO> convertTo(List<CurrencyRateVO> currencies,Currency newBase) throws NoCurrencyDataException;
    
}
