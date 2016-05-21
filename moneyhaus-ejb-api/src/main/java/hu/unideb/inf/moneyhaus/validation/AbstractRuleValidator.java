package hu.unideb.inf.moneyhaus.validation;

import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * An Abstract validator to validate objects.
 *
 * @param <T> the object type to be validated
 */
public class AbstractRuleValidator<T> {

    /**
     * The list of the validation rules.
     */
    protected List<ValidationRule<T>> rules;

    /**
     * Constructor to initialize validation rules.
     *
     * @param rules the rules to validate by
     */
    public AbstractRuleValidator(List<ValidationRule<T>> rules) {
        this.rules = rules;
    }

    /**
     * Validate an object by the rules specified.
     *
     * @param object the object to be validated
     * @throws ValidationException if any validationrule fails
     */
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
