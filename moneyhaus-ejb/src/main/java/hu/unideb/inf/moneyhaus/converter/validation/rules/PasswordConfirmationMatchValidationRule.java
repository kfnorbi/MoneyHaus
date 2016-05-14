/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter.validation.rules;

import hu.unideb.inf.moneyhaus.validation.ValidationRule;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public class PasswordConfirmationMatchValidationRule implements ValidationRule<RegistrationRequest>{

    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        if (entity.getPassword().trim().equals(entity.getPasswordConfirmation().trim())){
            return Collections.<ValidationViolation>emptyList();
        }else{
            return Arrays.asList(new ValidationViolation("password","A két jelszó nem egyezik"));
        }
    }
    
}
