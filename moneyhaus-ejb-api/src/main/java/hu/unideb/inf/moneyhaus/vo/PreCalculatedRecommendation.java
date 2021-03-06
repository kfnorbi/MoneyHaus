package hu.unideb.inf.moneyhaus.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * This class is representing a previously calculated recommendation which
 * fastens the response time.
 */
public class PreCalculatedRecommendation extends BaseVO {

    /**
     * The recommended currency.
     */
    private String currency;
    /**
     * The date of recommendation.
     */
    private Date date;

    /**
     * The growth of the currency rate.
     */
    private BigDecimal growth;

    /**
     * Returns the growth of the recommendation.
     *
     * @return the growth of the recommendation
     */
    public BigDecimal getGrowth() {
        return growth;
    }

    /**
     * Sets the growth of the recommendation.
     *
     * @param growth the growth of the recommendation
     */
    public void setGrowth(BigDecimal growth) {
        this.growth = growth;
    }

    /**
     * Returns the currency code of the recommendation.
     *
     * @return the currency code of the recommendation
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code of the recommendation.
     *
     * @param currency the currency code of the recommendation
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Returns the date of the recommendation.
     *
     * @return the date of the recommendation
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the recommendation.
     *
     * @param date the date of recommendation
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.currency);
        hash = 31 * hash + Objects.hashCode(this.date);
        hash = 31 * hash + Objects.hashCode(this.growth);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PreCalculatedRecommendation other = (PreCalculatedRecommendation) obj;
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.growth, other.growth)) {
            return false;
        }
        return true;
    }

}
