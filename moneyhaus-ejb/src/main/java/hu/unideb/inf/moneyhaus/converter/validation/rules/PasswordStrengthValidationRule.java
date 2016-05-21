
package hu.unideb.inf.moneyhaus.converter.validation.rules;

import hu.unideb.inf.moneyhaus.validation.ValidationRule;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.Validate;

/**
 * A password strength validation rule.
 */
public class PasswordStrengthValidationRule implements ValidationRule<RegistrationRequest> {

    /**
     * Password pattern.
     */
    private static final String PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[^ ]{6,10}$";

    /**
     * A password strength validation rule.
     *
     * @param entity the entity to be validated
     * @return {@link java.util.List List} if :
     * <ul>
     * <li>the password's is shorter then 6 or longer then 10 characters</li>
     * <li>the password does not contain at lest one capital letter and a
     * number</li>
     * </ul>
     */
    @Override
    public List<ValidationViolation> validate(RegistrationRequest entity) {
        Validate.notNull(entity);
        Validate.notNull(entity.getPassword());
        if (entity.getPassword().trim().matches(PATTERN)) {
            return Collections.<ValidationViolation>emptyList();
        } else {
            return Arrays.asList(new ValidationViolation("password", "A megadott jelszó gyenge"));
        }
    }

}
