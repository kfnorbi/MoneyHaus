/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.exception.CurrencyOverloadException;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@RequestScoped
public class HomeMBean {

    Date startDate;

    Date endDate;

    List<Currency> selected = new ArrayList<>();

    LineChartModel lineChartModel;

    @EJB
    CurrencyRateService currencyRateService;

    public List<Currency> getAllAvalibleCurrencies() {
        List<Currency> temp = new ArrayList<>(Currency.getAvailableCurrencies());
        Collections.sort(temp, new Comparator<Currency>() {
            @Override
            public int compare(Currency o1, Currency o2) {
                return o1.getCurrencyCode().compareTo(o2.getCurrencyCode());
            }

        });
        return temp;
    }

    private void initLineChartModel(Map<Currency, List<CurrencyRateVO>> rates) {
        lineChartModel = new LineChartModel();

        lineChartModel.setAnimate(true);
        lineChartModel.setTitle("Valuták");
        for (Currency c : rates.keySet()) {
            ChartSeries series = new ChartSeries(c.getCurrencyCode());
            List<CurrencyRateVO> currencyRates = rates.get(c);
            for (CurrencyRateVO currency : currencyRates) {
                series.set(currency.getDateTime(), currency.getRate());
            }
            lineChartModel.addSeries(series);
        }

    }

    public void setLineChartModel(LineChartModel lineChartModel) {
        this.lineChartModel = lineChartModel;
    }

    public List<Currency> getSelected() {
        return selected;
    }

    public void updateLineChartModel() {
        try {
            Map<Currency, List<CurrencyRateVO>> rates = currencyRateService.findCurrenciesByCode(selected);
            initLineChartModel(rates);
        } catch (CurrencyOverloadException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), null);
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public LineChartModel getLineChartModel() {
        return lineChartModel;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
