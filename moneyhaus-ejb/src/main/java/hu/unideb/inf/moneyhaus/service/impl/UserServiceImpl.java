package hu.unideb.inf.moneyhaus.service.impl;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.converter.RegistrationRequestToUserVOConverter;
import hu.unideb.inf.moneyhaus.converter.validation.RegistrationRequestValidator;
import hu.unideb.inf.moneyhaus.converter.validation.rules.EmailValidationRule;
import hu.unideb.inf.moneyhaus.converter.validation.rules.ExistingUserNameValidationRule;
import hu.unideb.inf.moneyhaus.converter.validation.rules.PasswordConfirmationMatchValidationRule;
import hu.unideb.inf.moneyhaus.converter.validation.rules.PasswordStrengthValidationRule;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import hu.unideb.inf.moneyhaus.repositories.RoleDao;
import hu.unideb.inf.moneyhaus.repositories.UserDao;
import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import hu.unideb.inf.moneyhaus.vo.RoleVO;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.Arrays;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements methods to manage users. Only some basic CRUD methods
 * are needed.
 *
 * @author Nolbelt
 */
@Stateless(mappedName = "userService")
@Remote(UserService.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceImpl implements UserService, Serializable {

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * UserDao.
     */
    @Autowired
    private UserDao userDao;
    /**
     * RoleDao.
     */
    @Autowired
    private RoleDao roleDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO findById(Long id) {
        return GenericConverter.mapTo(userDao.findOne(id), UserVO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO findByUsername(String username) {
        logger.debug("Trying to find " + username + ".");
        return GenericConverter.mapTo(userDao.findByUserName(username), UserVO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists(String userName) {
        return userDao.findByUserName(userName) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registrate(RegistrationRequest registrationRequest) throws ValidationException {
        RegistrationRequestValidator validator = new RegistrationRequestValidator(Arrays.asList(
                new EmailValidationRule(),
                new ExistingUserNameValidationRule(),
                new PasswordConfirmationMatchValidationRule(),
                new PasswordStrengthValidationRule()));

        validator.validate(registrationRequest);

        UserVO user = RegistrationRequestToUserVOConverter.convert(registrationRequest);
        user.setRoles(GenericConverter.mapTo(Arrays.asList(roleDao.findByValue("ROLE_USER")), RoleVO.class));
        userDao.save(GenericConverter.mapTo(user, UserEntity.class));
    }

}
