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
 * @author Nolbelt
 */
@Entity
@Table(name="daily_average")
public class DailyAveragePreCalculatedEntity extends BaseEntity {

    @Column(name = "value")
    private Double value;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_average")
    private Date date;

    @Column(name = "currency_code")
    private String currencyCode;

    public Double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
