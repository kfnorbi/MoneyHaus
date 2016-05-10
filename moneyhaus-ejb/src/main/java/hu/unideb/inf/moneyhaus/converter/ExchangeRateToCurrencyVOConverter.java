/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter;

import com.github.sarxos.xchange.ExchangeRate;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public class ExchangeRateToCurrencyVOConverter {
    
    public static CurrencyRateVO toLocal(ExchangeRate excrate){
        if (excrate == null){
            throw new NullPointerException();
        }
        CurrencyRateVO vo = new CurrencyRateVO();
        vo.setBase(excrate.getFrom());
        vo.setRate(excrate.getRate());
        vo.setCurrencyCode(excrate.getTo());
        vo.setDateTime(new Date());
        return vo;
    }
    
    public static List<CurrencyRateVO> toLocal(List<ExchangeRate> excrates){
        if (excrates == null){
            throw new NullPointerException();
        }
        List<CurrencyRateVO> rates = new ArrayList<>();
        for (ExchangeRate excrate : excrates) {
            rates.add(toLocal(excrate));
        }
        return rates;
    }
    
}
