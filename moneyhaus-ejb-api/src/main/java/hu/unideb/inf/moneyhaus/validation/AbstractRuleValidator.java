/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.validation;

import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public class AbstractRuleValidator<T> {

    protected List<ValidationRule<T>> rules;

    public AbstractRuleValidator(List<ValidationRule<T>> rules) {
        this.rules = rules;
    }

    public void validate(T object) throws ValidationException {

        List<ValidationViolation> violations = new ArrayList<>();
        for (ValidationRule<T> rule : this.rules) {
            violations.addAll(rule.validate(object));
        }

        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }

}
