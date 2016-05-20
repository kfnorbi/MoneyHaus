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
 * This class validates
 * {@link hu.unideb.inf.moneyhaus.vo.RegistrationRequest RegistrationRequest}s.
 *
 */
public class RegistrationRequestValidator extends AbstractRuleValidator<RegistrationRequest> {

    /**
     * Constructor.
     *
     * @param rules the rules to validate a registrate request by
     */
    public RegistrationRequestValidator(List<ValidationRule<RegistrationRequest>> rules) {
        super(rules);
    }

}
