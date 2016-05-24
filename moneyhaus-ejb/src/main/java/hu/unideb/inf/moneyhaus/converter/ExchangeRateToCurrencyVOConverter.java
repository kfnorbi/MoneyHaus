
package hu.unideb.inf.moneyhaus.converter;

import com.github.sarxos.xchange.ExchangeRate;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Converts value objects from a
 * <a href="https://github.com/sarxos/exchange-rates-api">third party
 * library</a> to local objects.
 *
 */
public class ExchangeRateToCurrencyVOConverter {

    /**
     * Maps an exchange rate object to a local one.
     *
     * @param excrate the exchange rate to map
     * @return the own representation of the currency rate.
     */
    public static CurrencyRateVO toLocal(ExchangeRate excrate) {
        if (excrate == null) {
            throw new NullPointerException();
        }
        CurrencyRateVO vo = new CurrencyRateVO();
        vo.setBase(excrate.getFrom());
        vo.setRate(excrate.getRate());
        vo.setCurrencyCode(excrate.getTo());
        vo.setDate(new Date());
        return vo;
    }

    /**
     * Maps the exchange rates objects to local ones.
     *
     * @param excrates the exchange rateS to map
     * @return the own representation of the currency rates.
     */
    public static List<CurrencyRateVO> toLocal(List<ExchangeRate> excrates) {
        if (excrates == null) {
            throw new NullPointerException();
        }
        List<CurrencyRateVO> rates = new ArrayList<>();
        for (ExchangeRate excrate : excrates) {
            rates.add(toLocal(excrate));
        }
        return rates;
    }

}
