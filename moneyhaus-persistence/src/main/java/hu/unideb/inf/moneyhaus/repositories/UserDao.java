package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * This interfaces is for getting data from a persistence.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserDao extends JpaRepository<UserEntity, Long> {

    /**
     * Returns a user object with username {@code userName}.
     *
     * @param userName the username of the user
     * @return the user with the username {@code userName}
     */
    public UserEntity findByUserName(String userName);

}
