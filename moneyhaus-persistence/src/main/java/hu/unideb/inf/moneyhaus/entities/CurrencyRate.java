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
 * The basic persistable representation of a refreshable currency rate.
 *
 */
@Entity
@Table(name = "currency_rate")
public class CurrencyRate extends BaseEntity implements Serializable {

    /**
     * The currency code of the represented currency rate.
     */
    @Column(name = "currency_code")
    private String currencyCode;

    /**
     * The date of refresh.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_refresh")
    private Date date;

    /**
     * The exchange rate of the currency.
     */
    @Column(name = "rate", precision = 20, scale = 10)
    private BigDecimal rate;

    /**
     * The base of the currency rate.
     */
    @Column(name = "base")
    private String base;

    /**
     * Returns the currency code of currency rate represented by this class.
     *
     * @return the currency code of the represented currency
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code of currency rate represented by this class.
     *
     * @param currencyCode the currency code to be represented by this object
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Returns the date of the refresh which created this class.
     *
     * @return the date of refreshment
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the refresh which created this class.
     *
     * @param date the date of the refresh
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * Returns the currency code of the base the currency is represented by.
     *
     * @return the base of the currency
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets the currency code of the base the currency is represented by.
     *
     * @param base the base of the currency
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     *
     * Returns the rate of the currency exchange rate from base to currencyCode.
     *
     * @return the exchange rate from base to currencyCode.
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     *
     * Sets the rate of the currency exchange rate from base to currencyCode.
     *
     * @param rate the exchange rate of the currency
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
