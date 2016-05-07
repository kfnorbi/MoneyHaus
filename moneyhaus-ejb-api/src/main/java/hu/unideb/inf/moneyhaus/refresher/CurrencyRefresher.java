package hu.unideb.inf.moneyhaus.refresher;

import hu.unideb.inf.moneyhaus.refresher.exception.CurrencyRefreshingException;


public interface CurrencyRefresher {

    public void refresh() throws CurrencyRefreshingException;

}
