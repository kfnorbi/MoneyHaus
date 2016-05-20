/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter;

import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import hu.unideb.inf.moneyhaus.vo.RoleVO;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.Arrays;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * This class maps registration request to fully verified user objects, which
 * are suitable to persist.
 */
public class RegistrationRequestToUserVOConverter {

    /**
     * Maps each field to a verified user object with the password field
     * encrypted by BCrypt encrypting method.
     *
     * @param registrationRequest to be mapped
     * @return the verified user object
     */
    public static UserVO convert(RegistrationRequest registrationRequest) {
        UserVO userVO = new UserVO();

        userVO.setAge(registrationRequest.getAge());
        userVO.setEmail(registrationRequest.getEmail().trim());
        userVO.setFirstName(registrationRequest.getFirstName().trim());
        userVO.setLastName(registrationRequest.getLastName().trim());
        userVO.setPassword(BCrypt.hashpw(registrationRequest.getPassword().trim(), BCrypt.gensalt(8)));
        userVO.setUserName(registrationRequest.getUserName().trim());
        return userVO;
    }

}
