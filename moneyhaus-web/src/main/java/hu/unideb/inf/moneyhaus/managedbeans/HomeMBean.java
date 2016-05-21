
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.vo.DailyAveragePreCalculated;
import hu.unideb.inf.moneyhaus.service.DailyAveragePreCalculatedService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

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
        LineChartModel lineChartModel = new LineChartModel();
        lineChartModel.setLegendPosition("e");

        Axis yAxis = lineChartModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(1000);

        yAxis = lineChartModel.getAxis(AxisType.X);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(2000);
        for (String currencyCode : selected) {
            LineChartSeries series = new LineChartSeries();
            series.setLabel(currencyCode);
            for (DailyAveragePreCalculated entity : dailyAveragePreCalculatedService.findByCurrencyCodeSince(currencyCode, startDate)) {
                series.set(entity.getDate(), entity.getValue());
            }
            lineChartModel.addSeries(series);
        }

        return lineChartModel;
    }

    public Date retrieveCurrentDate() {
        return new Date();
    }

    public List<String> retrieveAllManagedCurrencies() {
        return currencyRateService.getAllManagedCurrencies();
    }
}
