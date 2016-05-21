
package hu.unideb.inf.moneyhaus.repositories;

import hu.unideb.inf.moneyhaus.entities.OwnedCurrenciesEntity;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nolbelt
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface OwnedCurrencyDao extends JpaRepository<OwnedCurrenciesEntity, Long> {

    /**
     *
     * Returns all the owned currencies owned by {@code user}.
     *
     * @param user the user whose owned currencies are needed
     * @return the owned currencies of {@code user}
     */
    public List<OwnedCurrenciesEntity> findByUser(UserEntity user);

}
