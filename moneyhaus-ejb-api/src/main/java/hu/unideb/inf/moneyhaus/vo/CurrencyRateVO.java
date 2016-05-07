package hu.unideb.inf.moneyhaus.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CurrencyRateVO {

    private String currencyCode;

    private Date dateTime;

    private BigDecimal rate;

    private String base;

    public CurrencyRateVO() {
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
