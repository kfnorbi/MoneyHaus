package hu.unideb.inf.moneyhaus.integration.jobs;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import hu.unideb.inf.moneyhaus.refresher.CurrencyRefresher;
import hu.unideb.inf.moneyhaus.refresher.PreCalculatedRecommendationRefresher;
import hu.unideb.inf.moneyhaus.refresher.exception.CurrencyRefreshingException;
import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;

@DisallowConcurrentExecution
public class CurrencyRefresherJob implements Job {

    CurrencyRefresher currencyRefresher;

    PreCalculatedRecommendationRefresher preCalculatedRecommendationRefresher;

    public CurrencyRefresherJob() {
        init();
    }

    private void init() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            currencyRefresher = (CurrencyRefresher) ctx
                    .lookup("currencyRefresher#hu.unideb.inf.moneyhaus.refresher.CurrencyRefresher");
            preCalculatedRecommendationRefresher = (PreCalculatedRecommendationRefresher) ctx
                    .lookup("preCalculatedRecommendationRefresher#hu.unideb.inf.moneyhaus.refresher.PreCalculatedRecommendationRefresher");

        } catch (NamingException e) {

        } finally {
            try {
                ctx.close();
            } catch (Exception ex) {

            }
        }

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            currencyRefresher.refresh();
            preCalculatedRecommendationRefresher.refresh();
        } catch (CurrencyRefreshingException e) {
            throw new JobExecutionException(e);
        }
    }

}
