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
package hu.unideb.inf.moneyhaus.test.converter;

import hu.unideb.inf.moneyhaus.converter.RegistrationRequestToUserVOConverter;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Nolbelt
 */
public class RegistrationRequestToUserVOConverterTest {

    public RegistrationRequestToUserVOConverterTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testNullParameter() {
        RegistrationRequestToUserVOConverter.convert(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullEmail() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        RegistrationRequestToUserVOConverter.convert(registrationRequest);
    }

    @Test(expected = NullPointerException.class)
    public void testNullUserName() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        RegistrationRequestToUserVOConverter.convert(registrationRequest);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPassword() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        RegistrationRequestToUserVOConverter.convert(registrationRequest);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPasswordConfirmation() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        RegistrationRequestToUserVOConverter.convert(registrationRequest);
    }

    @Test(expected = NullPointerException.class)
    public void testNullFirstname() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        RegistrationRequestToUserVOConverter.convert(registrationRequest);
    }

    @Test(expected = NullPointerException.class)
    public void testNullLastname() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        RegistrationRequestToUserVOConverter.convert(registrationRequest);
    }

    @Test
    public void testConvertingShouldWork() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setAge(0);
        registrationRequest.setEmail("test@email.com");
        registrationRequest.setFirstName("Test");
        registrationRequest.setLastName("User");
        registrationRequest.setPassword("password");
        registrationRequest.setPasswordConfirmation("password");
        registrationRequest.setUserName("user");
        UserVO user = RegistrationRequestToUserVOConverter.convert(registrationRequest);

        assertEquals(registrationRequest.getAge(), user.getAge());
        assertEquals(registrationRequest.getEmail(), user.getEmail());
        assertEquals(registrationRequest.getFirstName(), user.getFirstName());
        assertEquals(registrationRequest.getLastName(), user.getLastName());

        assertTrue(BCrypt.checkpw(registrationRequest.getPassword(), user.getPassword()));
        assertEquals(registrationRequest.getUserName(), user.getUserName());
    }
}
