package hu.unideb.inf.moneyhaus.test.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.RoleEntity;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.Arrays;

public class GenericConverterTest {

    UserEntity user;

    @Before
    public void before() {
        user = new UserEntity();
        user.setAge(500);
        user.setLastName("Test");
        user.setFirstName("User");
        user.setPassword("password");
        RoleEntity entity = new RoleEntity();
        entity.setValue("TEST_ROLE");
        user.setRoles(Arrays.asList());
        user.setUserName("test");
        user.setEmail("test@email.com");
    }

    @Test
    public void testConvert() {
        UserVO userVO = GenericConverter.mapTo(user, UserVO.class);
        assertEquals(user.getUserName(), userVO.getUserName());
        assertEquals(user.getEmail(), userVO.getEmail());
        assertEquals(user.getLastName(), userVO.getLastName());
        assertEquals(user.getAge(), userVO.getAge());
        assertEquals(user.getFirstName(), userVO.getFirstName());
        assertEquals(user.getPassword(), userVO.getPassword());
        assertEquals(user.getRoles(), userVO.getRoles());
    }

    public GenericConverterTest() {
    }

}
