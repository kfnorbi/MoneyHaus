package hu.unideb.inf.moneyhaus.converter.validation;

import hu.unideb.inf.moneyhaus.validation.AbstractRuleValidator;
import hu.unideb.inf.moneyhaus.validation.ValidationRule;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.List;

/**
 * This class validates
 * {@link hu.unideb.inf.moneyhaus.vo.RegistrationRequest RegistrationRequest}.
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
