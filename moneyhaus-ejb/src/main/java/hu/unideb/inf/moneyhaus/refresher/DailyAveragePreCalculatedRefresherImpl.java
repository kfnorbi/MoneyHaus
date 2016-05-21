package hu.unideb.inf.moneyhaus.refresher;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.vo.DailyAveragePreCalculated;
import hu.unideb.inf.moneyhaus.service.DailyAveragePreCalculatedService;
import hu.unideb.inf.moneyhaus.service.RefreshResultService;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * This class calculates average daily currecncy exchange rates and saves them
 * to database.
 */
@Stateless
@Remote(DailyAveragePreCalculatedRefresher.class)
public class DailyAveragePreCalculatedRefresherImpl implements DailyAveragePreCalculatedRefresher {

    /**
     * DailyAveragePreCalculatedService.
     */
    @EJB
    DailyAveragePreCalculatedService dailyAveragePreCalculatedService;
    /**
     * CurrencyRateService.
     */
    @EJB
    CurrencyRateService currencyRateService;
    /**
     * RefreshResultService.
     */
    @EJB
    RefreshResultService refreshResultService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() {
        final List<String> currencies = currencyRateService.getAllManagedCurrencies();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        final Date date = calendar.getTime();
        List<DailyAveragePreCalculated> result = new LinkedList<>();
        for (String currencyCode : currencies) {
            try {
                Double avg = currencyRateService.findAverageOnDay(currencyCode, date);
                DailyAveragePreCalculated dailyAverage = new DailyAveragePreCalculated();
                dailyAverage.setValue(avg);
                dailyAverage.setDate(date);
                dailyAverage.setCurrencyCode(currencyCode);
                result.add(dailyAverage);
            } catch (Exception e) {

            }
        }
        dailyAveragePreCalculatedService.save(result);
    }

}
