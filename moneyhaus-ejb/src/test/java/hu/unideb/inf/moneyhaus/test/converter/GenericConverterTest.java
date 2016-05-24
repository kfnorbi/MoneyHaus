package hu.unideb.inf.moneyhaus.test.converter;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.CurrencyRate;
import hu.unideb.inf.moneyhaus.entities.RoleEntity;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.RoleVO;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GenericConverterTest {

    @Test
    public void testUserConvert() {
        UserEntity user = new UserEntity();
        user.setAge(500);
        user.setLastName("Test");
        user.setFirstName("User");
        user.setPassword("password");
        RoleEntity entity = new RoleEntity();
        entity.setValue("TEST_ROLE");
        user.setRoles(Arrays.asList());
        user.setUserName("test");
        user.setEmail("test@email.com");

        UserVO userVO = GenericConverter.mapTo(user, UserVO.class);
        assertEquals(user.getUserName(), userVO.getUserName());
        assertEquals(user.getEmail(), userVO.getEmail());
        assertEquals(user.getLastName(), userVO.getLastName());
        assertEquals(user.getAge(), userVO.getAge());
        assertEquals(user.getFirstName(), userVO.getFirstName());
        assertEquals(user.getPassword(), userVO.getPassword());
        assertEquals(user.getRoles(), userVO.getRoles());
    }

    @Test
    public void testRoleToRoleVO() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setValue("ROLE_TEST");

        assertEquals(roleEntity.getValue(), "ROLE_TEST");
    }

    @Test
    public void testRoleVOToRole() {
        RoleVO role = new RoleVO();
        role.setValue("ROLE_TEST");

        assertEquals(role.getValue(), "ROLE_TEST");
    }

    @Test
    public void testCurrencyRateToCurrencyRateVO() {
        CurrencyRate rate = new CurrencyRate();
        rate.setBase("EUR");
        rate.setCurrencyCode("GBP");
        rate.setRate(BigDecimal.ONE);
        rate.setId(1l);
        rate.setDate(new Date());

        CurrencyRateVO currencyRateVO = GenericConverter.mapTo(rate, CurrencyRateVO.class);

        assertEquals(rate.getBase(), currencyRateVO.getBase());
        assertEquals(rate.getRate(), currencyRateVO.getRate());
        assertEquals(rate.getCurrencyCode(), currencyRateVO.getCurrencyCode());
        assertEquals(rate.getDate(), currencyRateVO.getDate());
        assertEquals(rate.getId(), currencyRateVO.getId());
    }

    @Test
    public void testCurrencyRateVOToCurrencyRate() {
        CurrencyRateVO rate = new CurrencyRateVO();
        rate.setBase("EUR");
        rate.setCurrencyCode("GBP");
        rate.setRate(BigDecimal.ONE);
        rate.setId(1l);
        rate.setDate(new Date());

        CurrencyRate currencyRateVO = GenericConverter.mapTo(rate, CurrencyRate.class);

        assertEquals(rate.getBase(), currencyRateVO.getBase());
        assertEquals(rate.getRate(), currencyRateVO.getRate());
        assertEquals(rate.getCurrencyCode(), currencyRateVO.getCurrencyCode());
        assertEquals(rate.getDate(), currencyRateVO.getDate());
        assertEquals(rate.getId(), currencyRateVO.getId());
    }

    public GenericConverterTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testParameterIsNull() {
        assertNotNull(GenericConverter.mapTo(null, Object.class));
    }

    @Test
    public void testCurrencyRateVOToCurrencyRateList() {
        CurrencyRateVO rate1 = new CurrencyRateVO();
        rate1.setBase("EUR");
        rate1.setCurrencyCode("GBP");
        rate1.setRate(BigDecimal.ONE);
        rate1.setId(1l);
        rate1.setDate(new Date());

        CurrencyRateVO rate2 = new CurrencyRateVO();
        rate2.setBase("EUR");
        rate2.setCurrencyCode("GBP");
        rate2.setRate(BigDecimal.ONE);
        rate2.setId(1l);
        rate2.setDate(new Date());

        List<CurrencyRate> currencyRateVOs = GenericConverter.mapTo(Arrays.asList(rate1, rate2), CurrencyRate.class);

        assertEquals(rate1.getBase(), currencyRateVOs.get(0).getBase());
        assertEquals(rate1.getRate(), currencyRateVOs.get(0).getRate());
        assertEquals(rate1.getCurrencyCode(), currencyRateVOs.get(0).getCurrencyCode());
        assertEquals(rate1.getDate(), currencyRateVOs.get(0).getDate());
        assertEquals(rate1.getId(), currencyRateVOs.get(0).getId());

        assertEquals(rate2.getBase(), currencyRateVOs.get(1).getBase());
        assertEquals(rate2.getRate(), currencyRateVOs.get(1).getRate());
        assertEquals(rate2.getCurrencyCode(), currencyRateVOs.get(1).getCurrencyCode());
        assertEquals(rate2.getDate(), currencyRateVOs.get(1).getDate());
        assertEquals(rate2.getId(), currencyRateVOs.get(1).getId());
    }
}
