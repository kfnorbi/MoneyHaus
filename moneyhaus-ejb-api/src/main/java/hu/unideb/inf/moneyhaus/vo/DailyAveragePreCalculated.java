
package hu.unideb.inf.moneyhaus.vo;

import java.util.Date;

/**
 *
 * This class' purpose is to enhance the statistic calculations by doing
 * everything before a user could request it and persisting it.
 */
public class DailyAveragePreCalculated extends BaseVO {

    /**
     * The code of avarage currency.
     */
    private String currencyCode;

    /**
     * The date of the calculations.
     */
    private Date date;
    /**
     * The average of the calculated currency exchange rates.
     */
    private Double value;

    /**
     * Returns the currency code of the averaged currency.
     *
     * @return the currency code of the averaged currency
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code code of the averaged currency.
     *
     * @param currencyCode the code of the averaged currency
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Returns the date of the averaged currency.
     *
     * @return the date of the averaged currency
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the averaged currency.
     *
     * @param date the date of the averaged currency
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * The average value of the averaged currency.
     *
     * @return the value of the averaged currency
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets the value of the averaged currency.
     *
     * @param value the value of the averaged currency
     */
    public void setValue(Double value) {
        this.value = value;
    }

}
