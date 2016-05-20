/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter.validation.rules;

import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.validation.ValidationRule;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.naming.InitialContext;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;

/**
 * This class checks if the request's username has been occupied.
 *
 *
 */
public class ExistingUserNameValidationRule implements ValidationRule<RegistrationRequest> {

    /**
     * UserService.
     */
    UserService userService;

    /**
     * Default constructor.
     */
    public ExistingUserNameValidationRule() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();

            userService = (UserService) ctx.lookup("userService#hu.unideb.inf.moneyhaus.service.UserService");
        } catch (Exception e) {

        } finally {
            try {
                ctx.close();
            } catch (Exception e) {

            }
        }

    }

    /**
     * A username existence validation rule.
     *
     * @param entity the entity to be validated
     * @return {@link java.util.List List} of validation violations if there are
     * any, otherwise an empty list
     */
    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        if (userService.exists(entity.getUserName().trim())) {
            return Arrays.asList(new ValidationViolation("username", "Ez a felhasználónév már foglalt!"));
        } else {
            return Collections.<ValidationViolation>emptyList();
        }
    }

}
