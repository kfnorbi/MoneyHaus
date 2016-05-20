package hu.unideb.inf.moneyhaus.vo;

import java.util.Date;

/**
 * This class is for future purposes like statistics for the currency rate
 * providers.
 */
public class RefreshResult extends BaseVO {

    /**
     * The date of refresh.
     */
    private Date date;
    /**
     * The result of the refresh.
     */
    private RefreshStatus status;

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
     * Returns the status of the refresh.
     *
     * @return the status of the refresh
     */
    public RefreshStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the refresh.
     *
     * @param status the status of the refresh
     */
    public void setStatus(RefreshStatus status) {
        this.status = status;
    }

}
