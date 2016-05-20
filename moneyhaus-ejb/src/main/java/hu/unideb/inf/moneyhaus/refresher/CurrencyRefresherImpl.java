package hu.unideb.inf.moneyhaus.refresher;

import com.github.sarxos.xchange.ExchangeQuery;
import com.github.sarxos.xchange.ExchangeRate;
import hu.unideb.inf.moneyhaus.converter.ExchangeRateToCurrencyVOConverter;
import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import hu.unideb.inf.moneyhaus.entities.RefreshResultEntity;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import hu.unideb.inf.moneyhaus.refresher.exception.CurrencyRefreshingException;
import hu.unideb.inf.moneyhaus.repositories.CurrencyRateDao;
import hu.unideb.inf.moneyhaus.repositories.RefreshResultDao;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.RefreshResult;
import hu.unideb.inf.moneyhaus.vo.RefreshStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import javax.interceptor.Interceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * This class uses one Yahoo's webservice to collect currency exchange rate
 * information.
 */
@Stateless(mappedName = "currencyRefresher")
@Remote(CurrencyRefresher.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class CurrencyRefresherImpl implements CurrencyRefresher {

    /**
     * RefreshResult.
     */
    @Autowired
    RefreshResultDao refreshResultDao;
    /**
     *
     * CurrencyRate.
     */
    @Autowired
    CurrencyRateDao currencyRateDao;
    /**
     * Base to calculate by.
     */
    private final String BASE = "IQD";
    /**
     * logger.
     */
    private final Logger logger = LoggerFactory.getLogger(CurrencyRefresherImpl.class);
    /**
     * Currencies.
     */
    private static final List<String> CURRENCIES;

    static {

        List<String> temp = new ArrayList<>();

        for (Currency c : Currency.getAvailableCurrencies()) {
            temp.add(c.getCurrencyCode());
        }

        CURRENCIES = Collections.unmodifiableList(temp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() throws CurrencyRefreshingException {

        RefreshStatus status = RefreshStatus.SUCCESSFUL;
        try {
            ExchangeQuery query = new ExchangeQuery();

            List<ExchangeRate> remoteRates = new ArrayList<>();

            for (String currency : CURRENCIES) {
                Collection<ExchangeRate> rate = Collections.EMPTY_LIST;
                try {
                    rate = query.to(BASE).from(currency).get();
                } catch (Exception e) {
                    logger.info("Refreshing " + currency + " failed. Skipping to next entry.");
                }
                remoteRates.addAll(rate);
            }
            List<CurrencyRateVO> currencies = new ArrayList<>();
            for (ExchangeRate r : remoteRates) {
                currencies.add(ExchangeRateToCurrencyVOConverter.toLocal(r));
            }

            for (CurrencyRateVO c : currencies) {
                if (c.getRate() != null) {
                    currencyRateDao.save(GenericConverter.mapTo(c, CurrencyRate.class));
                }
            }
            logger.info("Saving " + currencies.size() + " successful!");
        } catch (Exception e) {
            status = RefreshStatus.FAILED;
            throw new CurrencyRefreshingException(e);
        } finally {
            RefreshResult result = new RefreshResult();
            result.setDate(new Date());
            result.setStatus(status);
            refreshResultDao.save(GenericConverter.mapTo(result, RefreshResultEntity.class));
        }
    }

}
