/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.validation.exception;

import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public class ValidationException extends Exception {

    List<ValidationViolation> violations;

    public ValidationException(List<ValidationViolation> violations) {
        this.violations = violations;
    }

    public List<ValidationViolation> getViolations() {
        return violations;
    }

}
