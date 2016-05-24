package hu.unideb.inf.moneyhaus.refresher;

import hu.unideb.inf.moneyhaus.converter.ExchangeRateToCurrencyVOConverter;
import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import hu.unideb.inf.moneyhaus.entities.RefreshResultEntity;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import hu.unideb.inf.moneyhaus.refresher.exception.CurrencyRefreshingException;
import hu.unideb.inf.moneyhaus.repositories.RefreshResultDao;
import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.RefreshResultService;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.RefreshResult;
import hu.unideb.inf.moneyhaus.vo.RefreshStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private RefreshResultService refreshResultService;
    /**
     *
     * CurrencyRate.
     */
    @EJB
    private CurrencyRateService currencyRateService;

    /**
     * logger.
     */
    private final Logger logger = LoggerFactory.getLogger(CurrencyRefresherImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() throws CurrencyRefreshingException {
        
        RefreshStatus status = RefreshStatus.SUCCESSFUL;
        try {
            
            YahooExchangeAccessor accessor = new YahooExchangeAccessor();
            
            List<CurrencyRateVO> currencies = new ArrayList<>(ExchangeRateToCurrencyVOConverter.toLocal(accessor.getExchangeRates()));
            
            currencyRateService.save(currencies);
            
            logger.info("Saving " + currencies.size() + " currencies was successful!");
        } catch (Exception e) {
            status = RefreshStatus.FAILED;
            logger.info("Error happened during refreshing currencies!");
            throw new CurrencyRefreshingException(e);
        } finally {
            RefreshResult result = new RefreshResult();
            result.setDate(new Date());
            result.setStatus(status);
            refreshResultService.save(result);
        }
    }
    
}
