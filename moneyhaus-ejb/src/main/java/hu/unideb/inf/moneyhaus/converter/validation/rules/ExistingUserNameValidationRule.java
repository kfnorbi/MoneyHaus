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
 *
 * @author Nolbelt
 */
public class ExistingUserNameValidationRule implements ValidationRule<RegistrationRequest> {

    UserService userService;

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

    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        if (userService.exists(entity.getUserName().trim())){
            return Arrays.asList(new ValidationViolation("username", "Ez a felhasználónév már foglalt!"));
        }else{
            return Collections.<ValidationViolation>emptyList();
        }
    }

}
