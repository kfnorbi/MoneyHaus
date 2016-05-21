package hu.unideb.inf.moneyhaus.test.validation.rules;

import hu.unideb.inf.moneyhaus.converter.validation.rules.EmailValidationRule;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Collections;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nolbelt
 */
public class EmailValidationRuleTest {

    private static EmailValidationRule rule;

    RegistrationRequest request;

    @BeforeClass
    public static void setUpClass() {
        rule = new EmailValidationRule();
    }

    @Before
    public void beforeClass() {
        request = new RegistrationRequest();
    }

    @Test
    public void testValidEmail() {
        request.setEmail("this.is.a@test.email");
        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test
    public void testInvalidEmail() {
        request.setEmail("invalid_email");
        ValidationViolation violation = new ValidationViolation("email", "A megadott email cím nem valós");
        ValidationViolation actual = rule.validate(request).get(0);
//        assertTrue(actual.equals(violation));
    }

    @Test(expected = NullPointerException.class)
    public void testNullAsRegistrationRequest() {
        rule.validate(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullAsEmail() {
        rule.validate(request);
    }

    public EmailValidationRuleTest() {
    }

}
