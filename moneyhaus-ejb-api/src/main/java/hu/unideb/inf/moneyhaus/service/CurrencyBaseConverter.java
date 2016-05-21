
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import java.math.BigDecimal;
import java.util.List;

/**
 * Responsible for converting
 * {@link hu.unideb.inf.moneyhaus.vo.CurrencyRateVO currency rate} to another
 * base.
 */
public interface CurrencyBaseConverter {

    /**
     * Convert currency rates to represent a conversion from {@code from}'s base
     * to {@code to}'s base.
     *
     * @param from the currency rate which base you want to convert from
     * @param to the currency rate which base you want to convert to
     * @return the currency rate representing a conversion from {@code from}'s
     * base to {@code to}'s base
     */
    public CurrencyRateVO convertTo(CurrencyRateVO from, CurrencyRateVO to);

    /**
     * Converts an {@link hu.unideb.inf.moneyhaus.vo.OwnedCurrency currency} to
     * another currency.
     *
     * @param currency the currency needed to be converterd
     * @param rate the currency code to be converted to
     * @return the value of {@code  currency} in the currency of {@code rate}
     * @throws NoCurrencyDataException if the application can't get any
     * conversion rate about the currencies
     */
    public BigDecimal getValue(OwnedCurrency currency, String rate) throws NoCurrencyDataException;

    /**
     * Converts {@link hu.unideb.inf.moneyhaus.vo.OwnedCurrency currencies} to
     * another currencies.
     *
     * @param currencies the currencies needed to be converterd
     * @param rate the currency code to be converted to
     * @return the value of {@code currency} in the currency of {@code rate}
     * @throws NoCurrencyDataException if the application can't get any
     * conversion rate about the currencies
     */
    public BigDecimal getValue(List<OwnedCurrency> currencies, String rate) throws NoCurrencyDataException;

}
