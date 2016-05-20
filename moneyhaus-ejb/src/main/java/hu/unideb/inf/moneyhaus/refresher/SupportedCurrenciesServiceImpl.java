/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.refresher;

import com.github.sarxos.xchange.ExchangeQuery;
import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import static javax.swing.text.html.HTML.Tag.BASE;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;

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
