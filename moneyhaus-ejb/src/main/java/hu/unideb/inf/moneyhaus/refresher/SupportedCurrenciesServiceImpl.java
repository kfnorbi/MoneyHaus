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
 *
 * @author Nolbelt
 */
//@Singleton
//@Stateful
public class SupportedCurrenciesServiceImpl implements SupportedCurrenciesService {

    @EJB
    CurrencyRateService currencyRateService;

    private List<String> supportedCurrencies;

    private static final String BASE = "USD";

    @PostConstruct
    public void init() {
        refreshSupportedCurrencies();
    }

    @Override
    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

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
