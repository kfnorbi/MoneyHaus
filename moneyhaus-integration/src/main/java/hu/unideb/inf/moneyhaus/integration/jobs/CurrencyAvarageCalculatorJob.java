// CHECKSTYLE:OFF
package hu.unideb.inf.moneyhaus.integration.jobs;

import hu.unideb.inf.moneyhaus.refresher.DailyAveragePreCalculatedRefresher;
import javax.naming.InitialContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class CurrencyAvarageCalculatorJob implements Job {

    private DailyAveragePreCalculatedRefresher dailyAveragePreCalculatedRefresher;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        dailyAveragePreCalculatedRefresher.refresh();
    }

    private void init() {
        InitialContext ic = null;
        try {
            ic = new InitialContext();
            dailyAveragePreCalculatedRefresher = (DailyAveragePreCalculatedRefresher) ic.lookup("dailyAveragePreCalculatedRefresherImpl#hu.unideb.inf.moneyhaus.refresher.DailyAveragePreCalculatedRefresher");
        } catch (Exception e) {

        } finally {
            try {
                ic.close();
            } catch (Exception ex) {

            }
        }
    }

    public CurrencyAvarageCalculatorJob() {
        init();
    }

}
