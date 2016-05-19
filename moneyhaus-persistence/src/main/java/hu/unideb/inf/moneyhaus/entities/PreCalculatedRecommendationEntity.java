/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.entities;

import java.math.BigDecimal;
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
@Table(name = "recommendations")
public class PreCalculatedRecommendationEntity extends BaseEntity {

    @Column(name = "currency_code", nullable = false, length = 3)
    private String currency;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_recommendation", nullable = false)
    private Date date;

    @Column(name = "growth", precision = 5)
    private BigDecimal growth;

    public BigDecimal getGrowth() {
        return growth;
    }

    public void setGrowth(BigDecimal growth) {
        this.growth = growth;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
