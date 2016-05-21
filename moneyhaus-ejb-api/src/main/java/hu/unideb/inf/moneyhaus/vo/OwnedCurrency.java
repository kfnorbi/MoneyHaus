
package hu.unideb.inf.moneyhaus.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A class to represent currrencies owned by users.
 *
 */
public class OwnedCurrency extends BaseVO {

    /**
     * The quatity of the owned currency.
     */
    private BigDecimal quantity;
    /**
     * The currency of the of the owned currency.
     */
    private String currency;

    /**
     * The date of buy of the owned currency.
     */
    private Date dateOfBuy;

    /**
     * The owner of the owned currency.
     */
    private UserVO user;

    /**
     * Returns the user of the owned currency.
     *
     * @return the user of the owned currency
     */
    public UserVO getUser() {
        return user;
    }

    /**
     * Sets the user of the owned currency.
     *
     * @param user the user of the owned currency
     */
    public void setUser(UserVO user) {
        this.user = user;
    }

    /**
     * The date of buy of the owned currency.
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
     * Returns the quantity of the owned currency.
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
     * Returns the currency of the owned currency.
     *
     * @return the currency of the owned currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency of the owned currency.
     *
     * @param currency the currency of the owned currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
