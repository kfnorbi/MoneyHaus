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
import org.springframework.data.convert.Jsr310Converters;

/**
 *
 * @author Nolbelt
 */
@Entity
@Table(name = "owned_currencies")
public class OwnedCurrenciesEntity extends BaseEntity {

    @Column(name = "currency_code")
    private String currency;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "date_of_buy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBuy;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(Date dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

}
