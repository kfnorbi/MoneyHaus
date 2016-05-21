package hu.unideb.inf.moneyhaus.test.validation.rules;

import hu.unideb.inf.moneyhaus.converter.validation.rules.PasswordStrengthValidationRule;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Nolbelt
 */
public class PasswordStrengthValidationRuleTest {

    private static PasswordStrengthValidationRule rule;

    private RegistrationRequest request;

    @BeforeClass
    public static void setUpClass() {
        rule = new PasswordStrengthValidationRule();
    }

    @Before
    public void setUp() {
        request = new RegistrationRequest();
    }

    @Test
    public void testPasswordStrengthSufficient() {
        request.setPassword("Test123");
        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test
    public void testPasswordLengthIsTooShort() {
        request.setPassword("Shrt1");
//        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test
    public void testPasswordLengthIsTooLong() {
        request.setPassword("TooLongPassword100");
//        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test
    public void testPasswordNotContainingNumber() {
        request.setPassword("Password");
//        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test
    public void testPasswordNotContainingUpperCaseLetter() {
        request.setPassword("passwd122");
//        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test(expected = NullPointerException.class)
    public void testParameterIsNull() {
        rule.validate(null);
    }

    @Test(expected = NullPointerException.class)
    public void testPasswordIsNull() {
        request.setPassword(null);
        rule.validate(request);
    }

    public PasswordStrengthValidationRuleTest() {
    }

}
