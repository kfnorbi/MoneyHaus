/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * This is a representation of the average currency exchange rates of a day.
 * <p>
 * The class' only purpose to reduce the calculation expense on a single
 * request.
 *
 */
@Entity
@Table(name = "daily_average")
public class DailyAveragePreCalculatedEntity extends BaseEntity {

    /**
     * The value of the calculated average.
     */
    @Column(name = "value")
    private Double value;

    /**
     * The day of the currency refresh calculated from.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_average")
    private Date date;

    /**
     * The currency code the average currency.
     */
    @Column(name = "currency_code")
    private String currencyCode;

    /**
     *
     * Returns the rate of the currency {@link #getCurrencyCode() currency}
     * specified on the day specified by {@link #getDate() date}.
     *
     * @return the average of rate of the specified currency code on the day
     * specified by date
     */
    public Double getValue() {
        return value;
    }

    /**
     * Returns the day the refresh the average is calculated from.
     *
     * @return the day the refresh the average is calculated from
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the currency code of the average rates calculated from.
     *
     * @return the currency code of the average
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code of the average rates calculated from.
     *
     * @param currencyCode the currency code of the average
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Sets the average value of the currency.
     *
     * @param value the currency rate
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Returns the day of the currency rates the calculation is from.
     *
     * @param date the day of the currency rates the calculation is from
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
