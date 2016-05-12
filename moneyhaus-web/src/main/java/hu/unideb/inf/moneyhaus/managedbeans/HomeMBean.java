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
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@ViewScoped
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
    
    public List<String> allManagedCurrencies(){
        return currencyRateService.getAllManagedCurrencies();
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
    
    public LineChartModel getLinearModel(){
        LineChartModel model = new LineChartModel();
 
        for (Currency c :selected){
            LineChartSeries series = new LineChartSeries(c.getDisplayName());
            List<CurrencyRateVO> rates = currencyRateService.findByCurrencyCode(c.getCurrencyCode());
            for (CurrencyRateVO rate :rates){
                series.set(rate.getDateTime(), rate.getRate());
            }
            model.addSeries(series);
        }
        
//        LineChartSeries series1 = new LineChartSeries();
//        series1.setLabel("Series 1");
// 
//        series1.set(1, 2);
//        series1.set(2, 1);
//        series1.set(3, 3);
//        series1.set(4, 6);
//        series1.set(5, 8);
// 
//        LineChartSeries series2 = new LineChartSeries();
//        series2.setLabel("Series 2");
// 
//        series2.set(1, 6);
//        series2.set(2, 3);
//        series2.set(3, 2);
//        series2.set(4, 7);
//        series2.set(5, 9);
// 
//        model.addSeries(series1);
//        model.addSeries(series2);
         
        return model;
    }

}
