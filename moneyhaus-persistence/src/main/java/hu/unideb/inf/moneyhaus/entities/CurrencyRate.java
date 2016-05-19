package hu.unideb.inf.moneyhaus.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: CurrencyRate
 *
 */
@Entity
@Table(name = "currency_rate")
public class CurrencyRate extends BaseEntity implements Serializable {


    @Column(name = "currency_code")
    private String currencyCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_refresh")
    private Date date;

    @Column(name = "rate",precision = 20,scale = 10)
    private BigDecimal rate;

    @Column(name = "base")
    private String base;

    public Date getDateTime() {
        return date;
    }

    public void setDateTime(Date date) {
        this.date = date;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
