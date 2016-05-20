package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.RefreshResult;
import java.util.Date;

/**
 *
 * This contains basic methods for managing refresh results.
 */
public interface RefreshResultService {

    /**
     * Saves a RefreshResult.
     *
     * @param result the RefreshResult to be saved
     */
    public void save(RefreshResult result);

    /**
     * Retrieves the latest
     * {@link hu.unideb.inf.moneyhaus.vo.RefreshStatus#SUCCESSFUL SUCCESSFUL}'s
     * date.
     *
     * @return the date of the last successful refresh
     */
    public Date findLastSuccessful();
}
