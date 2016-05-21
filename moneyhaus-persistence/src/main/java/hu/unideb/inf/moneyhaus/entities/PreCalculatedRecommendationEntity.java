
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
 * This class' only purpose to encrease the speed of the recommendation
 * algorithm<br>
 * by calculating it before anybody would try to request it.
 */
@Entity
@Table(name = "recommendations")
public class PreCalculatedRecommendationEntity extends BaseEntity {

    /**
     * The currency code of the recommended currency.
     */
    @Column(name = "currency_code", nullable = false, length = 3)
    private String currency;

    /**
     * The date of the calculation.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_recommendation", nullable = false)
    private Date date;

    /**
     * The growth of the currency.
     */
    @Column(name = "growth", precision = 5)
    private BigDecimal growth;

    /**
     * Returns the growth of the currency.
     *
     * @return the growth of the currency
     */
    public BigDecimal getGrowth() {
        return growth;
    }

    /**
     * Sets the growth of the currency.
     *
     * @param growth the growth of the currency
     */
    public void setGrowth(BigDecimal growth) {
        this.growth = growth;
    }

    /**
     * Returns the code of the currency which average is represented.
     *
     * @return the code of the currency which average is represented.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the code of the currency which average is represented.
     *
     * @param currency the code of the currency which average is represented.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Returns the calculation date of the recommendation.
     *
     * @return the date of the recommendation
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the recommendation.
     *
     * @param date the date of the recommendation
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
