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
 * @author Nolbelt
 */
public interface ValidationRule<T> {
    
    public List
        <ValidationViolation> validate(T entity);
    
}
