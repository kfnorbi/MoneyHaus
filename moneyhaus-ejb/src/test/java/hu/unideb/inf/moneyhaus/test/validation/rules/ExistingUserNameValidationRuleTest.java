package hu.unideb.inf.moneyhaus.test.validation.rules;

import hu.unideb.inf.moneyhaus.converter.validation.rules.ExistingUserNameValidationRule;
import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Nolbelt
 */
public class ExistingUserNameValidationRuleTest {

    private static ExistingUserNameValidationRule rule;

    private RegistrationRequest request;

    @BeforeClass
    public static void setUpClass() {
        rule = new ExistingUserNameValidationRule();
    }

    @Before
    public void setUp() {
        request = new RegistrationRequest();
        UserService service = mock(UserService.class);
        when(service.findByUsername("test")).thenReturn(new UserVO());
    }

    @Test
    public void testUserNameNotExists() {
        UserService service = mock(UserService.class);
        request.setUserName("test");
        when(service.findByUsername("test")).thenReturn(new UserVO());
        rule.setUserService(service);
//        assertEquals(Arrays.asList(new ValidationViolation("username", "Ez a felhasználónév már foglalt!")), rule.validate(request));
    }

    @Test
    public void testUserNameExists() {
        UserService service = mock(UserService.class);
        request.setUserName("test");
        when(service.findByUsername("test")).thenReturn(null);
        rule.setUserService(service);
        assertEquals(rule.validate(request), Collections.EMPTY_LIST);
    }

    @Test(expected = NullPointerException.class)
    public void testNullParameter() {
        rule.validate(null);
    }

    @Test(expected = NullPointerException.class)
    public void testUserNameIsNull() {
        rule.validate(request);
    }

    public ExistingUserNameValidationRuleTest() {
    }

}
