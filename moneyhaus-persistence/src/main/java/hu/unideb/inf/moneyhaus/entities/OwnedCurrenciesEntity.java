
package hu.unideb.inf.moneyhaus.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 *
 *
 */
@Entity
@Table(name = "owned_currencies")
public class OwnedCurrenciesEntity extends BaseEntity {

    /**
     * The code of the currency owned by the user.
     */
    @Column(name = "currency_code")
    private String currency;

    /**
     * The quantity of the currency owned by the user.
     */
    @Column(name = "quantity")
    private BigDecimal quantity;

    /**
     * The date of buy.
     */
    @Column(name = "date_of_buy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBuy;

    /**
     * The owner of the owned currency.
     */
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    UserEntity user;

    /**
     * Returns the currency code of the owned currency.
     *
     * @return the currency code of the owned currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code of the owned currency.
     *
     * @param currency the currency code of the owned currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Returns the quantity of owned currency.
     *
     * @return the quantity of the owned currency
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the owned currency.
     *
     * @param quantity the quantity of the owned currency
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the date of buy of the owned currency.
     *
     * @return the date of buy of the owned currency
     */
    public Date getDateOfBuy() {
        return dateOfBuy;
    }

    /**
     * Sets the date of buy of the owned currency.
     *
     * @param dateOfBuy the date of buy of the owned currency
     */
    public void setDateOfBuy(Date dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    /**
     * Returns the owner user of the owned currency.
     *
     * @return the owner user of the owned currency
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Sets the owner user of the owner currency.
     *
     * @param user the user of the owner currency
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

}
