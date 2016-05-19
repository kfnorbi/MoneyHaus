/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.DailyAveragePreCalculated;
import hu.unideb.inf.moneyhaus.service.DailyAveragePreCalculatedService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@ViewScoped
public class HomeMBean {

    private Date startDate;

    private Date endDate;

    private List<String> selected = Arrays.asList("GBP");

    @EJB
    private CurrencyRateService currencyRateService;
    
    @EJB
    private DailyAveragePreCalculatedService dailyAveragePreCalculatedService;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }

    public LineChartModel getLineChartModel() {
        LineChartModel lineChartModel  = new LineChartModel();
        
        for(String currencyCode : selected){
            LineChartSeries series = new LineChartSeries(currencyCode);
            for (DailyAveragePreCalculated entity:dailyAveragePreCalculatedService.findByCurrencyCodeSince(currencyCode, startDate)){
                series.set(entity.getDate(), entity.getAverage());
            }
            lineChartModel.addSeries(series);
        }
        
        return lineChartModel;
    }
    public Date retrieveCurrentDate(){
        return new Date();
    }
    
    public List<String> retrieveAllManagedCurrencies(){
        return currencyRateService.getAllManagedCurrencies();
    }
}
