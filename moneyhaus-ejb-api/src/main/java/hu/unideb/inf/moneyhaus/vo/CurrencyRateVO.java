package hu.unideb.inf.moneyhaus.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class represents a currency exchange rate at a single moment.
 */
public class CurrencyRateVO extends BaseVO {

    /**
     * The code of the currency rate.
     */
    private String currencyCode;

    /**
     * The date of refresh.
     */
    private Date dateTime;

    /**
     * The rate of the currency exchange rate.
     */
    private BigDecimal rate;

    /**
     * The base of the currency rate.
     */
    private String base;

    /**
     * Default constructor.
     */
    public CurrencyRateVO() {
    }

    /**
     * Returns the date of the currency rate refresh.
     *
     * @return the date of the currency exchange rate refresh
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Sets the currency rate refresh date.
     *
     * @param dateTime the date to be set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Returns the currency code of the currency exchange rate.
     *
     * @return the currency code of the currency exchange rate
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code of the currency exchange rate.
     *
     * @param currencyCode the currency code to be set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Returns the base of the currency exchange rate.
     *
     * @return the base of the currency exchange rate.
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets the base of the currency exchange rate.
     *
     * @param base the base of the currency exchange rate
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Returns the currency exchange rate.
     *
     * @return the currency exchange rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Sets the currency exchange rate.
     *
     * @param rate the currency exchange rate
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
