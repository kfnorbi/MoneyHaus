package hu.unideb.inf.moneyhaus.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The class is for logging both the successful and unsuccessful refresh tries
 * for future purpuses.
 *
 */
@Entity
@Table(name = "refresh_results")
public class RefreshResultEntity extends BaseEntity {

    /**
     * The date of refresh.
     */
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * The status of the refresh.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ResultStatusEntity status;

    /**
     * Returns the date of the refresh.
     *
     * @return the date of the refresh
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the refresh.
     *
     * @param date the date of the refresh
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the outcome of the refresh.
     *
     * @return the outcome of the refresh
     */
    public ResultStatusEntity getStatus() {
        return status;
    }

    /**
     * Sets the outcome of the refresh.
     *
     * @param status the outcome of the refresh
     */
    public void setStatus(ResultStatusEntity status) {
        this.status = status;
    }

}
