package hu.unideb.inf.moneyhaus.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CurrencyRate
 *
 */
@Entity
@Table(name = "currency_rate")
public class CurrencyRate extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "date")
    private Date date;

    @Column(name = "rate")
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
