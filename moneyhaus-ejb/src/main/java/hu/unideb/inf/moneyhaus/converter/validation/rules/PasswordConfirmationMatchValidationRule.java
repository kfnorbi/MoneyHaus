
package hu.unideb.inf.moneyhaus.converter.validation.rules;

import hu.unideb.inf.moneyhaus.validation.ValidationRule;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.Validate;

/**
 * A basic password confirmation rule.
 *
 */
public class PasswordConfirmationMatchValidationRule implements ValidationRule<RegistrationRequest> {

    /**
     * This rule checks if the registration request's password and confirmation
     * password fields are the same.
     *
     * @param entity the entity to be validated
     * @return {@link java.util.List List} of validation violations if there are
     * any, otherwise an empty list
     */
    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        Validate.notNull(entity);
        Validate.notNull(entity.getPassword());
        Validate.notNull(entity.getPasswordConfirmation());
        if (entity.getPassword().trim().equals(entity.getPasswordConfirmation().trim())) {
            return Collections.<ValidationViolation>emptyList();
        } else {
            return Arrays.asList(new ValidationViolation("password", "A két jelszó nem egyezik"));
        }
    }

}
