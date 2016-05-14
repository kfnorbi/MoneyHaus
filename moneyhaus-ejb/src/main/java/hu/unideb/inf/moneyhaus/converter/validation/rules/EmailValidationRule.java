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
public class EmailValidationRule implements ValidationRule<RegistrationRequest>{

    private static final String PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        if (entity.getEmail().trim().matches(PATTERN)){
            return Collections.<ValidationViolation>emptyList();
        }else{
            return Arrays.asList(new ValidationViolation("email", "A megadott email cím nem valós"));
        }
    }
    
}
