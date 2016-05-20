package hu.unideb.inf.moneyhaus.refresher;

import hu.unideb.inf.moneyhaus.refresher.exception.CurrencyRefreshingException;

/**
 * Refresher for polling an external source to get currency rates.
 */
public interface CurrencyRefresher {

    /**
     *
     * Calls the external resource and saves the resulted currency exchange
     * rates.
     *
     * @throws CurrencyRefreshingException if any
     * {@link java.lang.Exception exception} occours
     */
    public void refresh() throws CurrencyRefreshingException;

}
