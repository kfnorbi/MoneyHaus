/*
 * The MIT License
 *
 * Copyright 2016 University of Debrecen, Faculty of Information Technology.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hu.unideb.inf.moneyhaus.test.validation;

import hu.unideb.inf.moneyhaus.converter.validation.RegistrationRequestValidator;
import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Nolbelt
 */
public class RegistrationRequestValidationTest {

    private RegistrationRequestValidator registrationRequestValidator;

    private RegistrationRequest request;

    @Before
    public void setUp() {
        request = new RegistrationRequest();
        request.setAge(0);
        request.setEmail("test@email.com");
        request.setFirstName("Test");
        request.setLastName("User");
        request.setPassword("password");
        request.setPasswordConfirmation("password");
        request.setUserName("user");
    }

    @Test
    public void testRegistrationValidationShouldWork() throws ValidationException {
        registrationRequestValidator = new RegistrationRequestValidator(Collections.EMPTY_LIST);
        registrationRequestValidator.validate(request);
    }

    @Test(expected = NullPointerException.class)
    public void testRegistrationRequestValidatorShouldThrowExceptionOnNullParameteR() throws ValidationException {
        registrationRequestValidator = new RegistrationRequestValidator(null);
        registrationRequestValidator.validate(request);
    }

}
