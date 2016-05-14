/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter.validation;

import hu.unideb.inf.moneyhaus.validation.AbstractRuleValidator;
import hu.unideb.inf.moneyhaus.validation.ValidationRule;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public class RegistrationRequestValidator extends  AbstractRuleValidator<RegistrationRequest>{

    public RegistrationRequestValidator(List<ValidationRule<RegistrationRequest>> rules) {
        super(rules);
    }
    
}
