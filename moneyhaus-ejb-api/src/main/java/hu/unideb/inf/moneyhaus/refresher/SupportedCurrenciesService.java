
package hu.unideb.inf.moneyhaus.refresher;

import java.util.List;

/**
 * Polls the webservice for every existing currency and saves the supported ones
 * to a singleton EJB instance.
 */
public interface SupportedCurrenciesService {

    /**
     * Returns the supported currencies implemented at the implementation of
     * {@link hu.unideb.inf.moneyhaus.refresher.SupportedCurrenciesService SupportedCurrenciesService}.
     *
     * @return the {@link java.util.List List} of the currency codes of the
     * supported currencies
     */
    public List<String> getSupportedCurrencies();

    /**
     * Tries to get every existing currency from the external currency rate
     * provider.
     */
    public void refreshSupportedCurrencies();

}
