package hu.unideb.inf.moneyhaus.test.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import hu.unideb.inf.moneyhaus.vo.UserVO;

public class GenericConverterTest {

	UserEntity user;

	@Before
	public void before(){
		user= new UserEntity();
		user.setUserName("test");
		user.setEmail("test@email.com");
	}

	@Test
	public void testConvert() {
		UserVO userVO= GenericConverter.mapTo(user, UserVO.class);
		assertEquals(user.getUserName(), userVO.getUserName());
		assertEquals(user.getEmail(), userVO.getEmail());
	}

}
