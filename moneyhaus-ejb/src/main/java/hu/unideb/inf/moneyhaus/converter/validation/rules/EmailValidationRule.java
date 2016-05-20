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
 * An email validation rule.
 */
public class EmailValidationRule implements ValidationRule<RegistrationRequest> {

    /**
     * Email pattern.
     */
    private static final String PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * A email formal validation rule.
     *
     * @param entity the entity to be validated
     * @return {@link java.util.List List} of validation violations if there are
     * any, otherwise an empty list
     */
    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        if (entity.getEmail().trim().matches(PATTERN)) {
            return Collections.<ValidationViolation>emptyList();
        } else {
            return Arrays.asList(new ValidationViolation("email", "A megadott email cím nem valós"));
        }
    }

}
