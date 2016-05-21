package hu.unideb.inf.moneyhaus.refresher;

import com.github.sarxos.xchange.ExchangeQuery;
import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 * This class polls Yahoo's finance webservice to determine which of them are
 * supported.
 */
//@Singleton
//@Stateful
public class SupportedCurrenciesServiceImpl implements SupportedCurrenciesService {

    /**
     * CurrencyRateService.
     */
    @EJB
    CurrencyRateService currencyRateService;
    /**
     * Supported currencies.
     */
    private List<String> supportedCurrencies;
    /**
     * Base to poll by.
     */
    private static final String BASE = "USD";

    /**
     * Postcosntruct method to refresh the currencies.
     */
    @PostConstruct
    private void init() {
        refreshSupportedCurrencies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void refreshSupportedCurrencies() {
        ExchangeQuery query = new ExchangeQuery();

        for (String currency : currencyRateService.getAllManagedCurrencies()) {
            try {
                query.to(BASE).from(currency).get();
                supportedCurrencies.add(currency);
            } catch (Exception e) {
            }
        }
    }

}
