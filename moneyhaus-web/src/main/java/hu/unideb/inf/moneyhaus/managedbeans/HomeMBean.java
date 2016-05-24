// CHECKSTYLE:OFF
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.vo.DailyAveragePreCalculated;
import hu.unideb.inf.moneyhaus.service.DailyAveragePreCalculatedService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
@ViewScoped
public class HomeMBean {

    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private Date startDate;

    private Date endDate;

    private List<String> selected = new ArrayList<>();

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
        yAxis.setMax(10000);
//        LineChartSeries series = new LineChartSeries();
//        series.setLabel("asdafaf");
//        series.set("addd", 50);
//        series.set("asdafasdad",150);
//        lineChartModel.addSeries(series);
//
////        LineChartSeries series2 = new LineChartSeries();
//        series2.setLabel("Series 2");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -2);
//        series2.set("a", new BigDecimal(BigInteger.TEN));
//        c.add(Calendar.DATE, -1);
//        series2.set("b", new BigDecimal(BigInteger.ONE));
//        c.add(Calendar.DATE, -1);
//        series2.set("c", new BigDecimal(BigInteger.TEN));
//        c.add(Calendar.DATE, -1);
//        series2.set("d", new BigDecimal(BigInteger.ONE));
//        c.add(Calendar.DATE, -1);
//        series2.set("e", new BigDecimal(BigInteger.TEN));

//        lineChartModel.addSeries(series2);
//        LineChartSeries series = new LineChartSeries();
        for (String currencyCode : selected) {
            LineChartSeries series = new LineChartSeries(currencyCode);
            Map<Object, Number> data = new HashMap<>();
            for (DailyAveragePreCalculated dailyAveragePreCalculated : dailyAveragePreCalculatedService.findByCurrencyCodeSince(currencyCode, startDate)) {
                data.put(format.format(dailyAveragePreCalculated.getDate()), dailyAveragePreCalculated.getValue());
            }
            series.setData(data);
            lineChartModel.addSeries(series);
        }
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setTickFormat("%y %b %#d ");

        lineChartModel.getAxes().put(AxisType.X, axis);
//        lineChartModel.addSeries(series);
//        }

        return lineChartModel;
    }

    public Date retrieveCurrentDate() {
        return new Date();
    }

    public List<String> retrieveAllManagedCurrencies() {
        return currencyRateService.getAllManagedCurrencies();
    }
}
