package hu.unideb.inf.moneyhaus.integration.jobs;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import hu.unideb.inf.moneyhaus.refresher.CurrencyRefresher;
import hu.unideb.inf.moneyhaus.refresher.exception.CurrencyRefreshingException;

@DisallowConcurrentExecution
public class CurrencyRefresherJob implements Job {

    CurrencyRefresher refresher;

    public CurrencyRefresherJob() {
        init();
    }

    private void init() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            refresher = (CurrencyRefresher)ctx
                    .lookup("currencyRefresher#hu.unideb.inf.moneyhaus.refresher.CurrencyRefresher");
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
        System.out.println("hu.unideb.inf.moneyhaus.integration.jobs.CurrencyRefresherJob.execute()");
        try {
            refresher.refresh();
        } catch (CurrencyRefreshingException e) {
            throw new JobExecutionException(e);
        }
    }

}
