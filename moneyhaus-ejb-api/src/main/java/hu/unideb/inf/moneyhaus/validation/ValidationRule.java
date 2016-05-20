/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.validation;

import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import java.util.List;

/**
 *
 * An interface to validate objects.
 *
 * @param <T> the object type to be validated
 */
public interface ValidationRule<T> {

    /**
     *
     * @param entity the object to be validated
     * @return the list of ValidationViolations containig the informations of
     * the failed rule(if it fails)<br>Returns empty list if the object passes.
     */
    public List<ValidationViolation> validate(T entity);

}
