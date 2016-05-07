package hu.unideb.inf.moneyhaus.refresher;

import com.github.sarxos.xchange.ExchangeCache;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "currencyRefresher")
@Remote(CurrencyRefresher.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class CurrencyRefresherImpl implements CurrencyRefresher {

    @Autowired
    RefreshResultDao refreshResultDao;

    @Autowired
    CurrencyRateDao currencyRateDao;

    private final String BASE = "USD";

    //TODO: szar
    @PostConstruct
    public void init() {

        try (InputStream is = this.getClass().getResourceAsStream("classpath:apikeys.properties")) {
            Properties apikeys = new Properties();
            apikeys.load(is);

            ExchangeCache.setParameter(apikeys.getProperty("openexchange", null), this);

        } catch (Exception ex) {
//             Logger.getLogger(CurrencyRefresherImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final List<String> CURRENCIES;

    static {
        //BULLSHIT REFACTOR NEEDED

        List<String> temp = new ArrayList<>();

        for (Currency c : Currency.getAvailableCurrencies()) {
            temp.add(c.getCurrencyCode());
        }

        CURRENCIES = Collections.unmodifiableList(temp);
    }

    @Override
    public void refresh() throws CurrencyRefreshingException {

        RefreshStatus status = RefreshStatus.SUCCESSFUL;
        try {
            ExchangeQuery query = new ExchangeQuery();

            List<ExchangeRate> remoteRates= new ArrayList<>();
            
            for (String currency : CURRENCIES) {
                Collection<ExchangeRate> rate = Collections.EMPTY_LIST;
                try {
                    rate = query.to(BASE).from(currency).get();
                }catch(Exception e){
                    System.out.println("hu.unideb.inf.moneyhaus.refresher.CurrencyRefresherImpl.refresh()");
                }
                remoteRates.addAll(rate);
            }
            //TODO : szar
            //List<CurrencyRateVO> currencies = GenericConverter.mapTo(rates, CurrencyRateVO.class, "currency-to-exchange");
            List<CurrencyRateVO> currencies = new ArrayList<>();
            for (ExchangeRate r : remoteRates) {
                currencies.add(ExchangeRateToCurrencyVOConverter.toLocal(r));
            }

            for (CurrencyRateVO c : currencies) {
                if (c.getRate() != null) {
                    currencyRateDao.save(GenericConverter.mapTo(c, CurrencyRate.class));
                }
            }

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
