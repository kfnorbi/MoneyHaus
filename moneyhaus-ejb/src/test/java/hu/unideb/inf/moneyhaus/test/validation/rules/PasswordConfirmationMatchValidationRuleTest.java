package hu.unideb.inf.moneyhaus.test.validation.rules;

import hu.unideb.inf.moneyhaus.converter.validation.rules.PasswordConfirmationMatchValidationRule;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Collections;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nolbelt
 */
public class PasswordConfirmationMatchValidationRuleTest {

    private static PasswordConfirmationMatchValidationRule rule;

    private RegistrationRequest request;

    @BeforeClass
    public static void setUpClass() {
        rule = new PasswordConfirmationMatchValidationRule();
    }

    @Before
    public void setUp() {
        request = new RegistrationRequest();
    }

    @Test
    public void testUserNameConfirmationMatch() {
        request.setPassword("test");
        request.setPasswordConfirmation("test");
        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test
    public void testUserNameConfirmationNotMatch() {
        request.setPassword("test");
        request.setPasswordConfirmation("password");
        rule.validate(request);
    }

    @Test(expected = NullPointerException.class)
    public void testUserNameConfirmationIsNull() {
        request.setAge(0);
        request.setUserName("test");
        request.setFirstName("test");
        request.setLastName("test");
        request.setPassword("test");
        request.setEmail("test");
        rule.validate(request);
    }

    @Test(expected = NullPointerException.class)
    public void testNullparameter() {
        rule.validate(null);
    }

    @Test(expected = NullPointerException.class)
    public void testPasswordIsNull() {
        request.setAge(0);
        request.setUserName("test");
        request.setFirstName("test");
        request.setLastName("test");
        request.setPasswordConfirmation("test");
        request.setEmail("test");
        rule.validate(request);
    }

    public PasswordConfirmationMatchValidationRuleTest() {
    }

}
