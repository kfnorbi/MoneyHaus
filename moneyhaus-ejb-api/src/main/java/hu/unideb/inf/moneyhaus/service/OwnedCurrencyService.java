
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.List;

/**
 *
 * Represents currencies owned by users.
 */
public interface OwnedCurrencyService {

    /**
     * Retrieves all the owned currencies owned by a user.
     *
     * @param user the owner of the currency
     * @return the owned currencies of the user specified
     */
    public List<OwnedCurrency> findByUser(UserVO user);

    /**
     * Saves an owned currency.
     *
     * @param ownedCurrency the owned currency to be saved
     */
    public void save(OwnedCurrency ownedCurrency);

    /**
     * Deletes an owned currency.
     *
     * @param ownedCurrency the owned currency to be deleted
     */
    public void delete(OwnedCurrency ownedCurrency);

}
