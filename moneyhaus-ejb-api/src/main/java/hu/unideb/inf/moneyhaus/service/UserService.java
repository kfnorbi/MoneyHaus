package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import hu.unideb.inf.moneyhaus.vo.UserVO;

/**
 *
 * This contains some basic methods for managing users.
 */
public interface UserService {

    /**
     * Returns a user by its id.
     *
     * @param id the id to be retrieved by
     * @return the user whose id is {@code id}
     */
    public UserVO findById(Long id);

    /**
     * Returns a user with the username of {@code username}.
     *
     * @param username the username to be retrieved by
     * @return the user with the username of {@code username}
     */
    public UserVO findByUsername(String username);

    /**
     * Checks whether a username is occupied.
     *
     * @param userName the username to be checked
     * @return {@link java.lang.Boolean#TRUE true} if the username is occupied,
     * {@link java.lang.Boolean#FALSE false} otherwise
     */
    public boolean exists(String userName);

    /**
     * Tries to registrate a request to be a validated user.
     *
     * @param registrationRequest the registrationrequest to be registered
     * @throws ValidationException if any registration constraint failed
     */
    public void registrate(RegistrationRequest registrationRequest) throws ValidationException;
}
