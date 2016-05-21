package hu.unideb.inf.moneyhaus.test.service.impl;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.service.impl.CurrencyBaseConverterImpl;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Nolbelt
 */
public class CurrencyBaseConverterImplTest {

    private CurrencyBaseConverterImpl baseConverterImpl;

    private CurrencyRateVO from;

    private CurrencyRateVO to;
    private OwnedCurrency ownedCurrency;

    @Before
    public void setUp() {
        from = new CurrencyRateVO();
        to = new CurrencyRateVO();
        baseConverterImpl = new CurrencyBaseConverterImpl();
        ownedCurrency = new OwnedCurrency();
    }

    @Test
    public void testBaseConversionOfSameCurrency() {
        from.setBase("GBP");
        from.setCurrencyCode("USD");
        from.setRate(new BigDecimal(1.45038));

        to.setBase("GBP");
        to.setCurrencyCode("USD");
        to.setRate(new BigDecimal(1.45038));

        CurrencyRateService service = mock(CurrencyRateService.class);
        baseConverterImpl.setCurrencyRateService(service);

        CurrencyRateVO actual = baseConverterImpl.convertTo(from, to);

        CurrencyRateVO expected = new CurrencyRateVO();

        expected.setBase("GBP");
        expected.setCurrencyCode("GBP");
        expected.setRate(BigDecimal.ONE);

        assertEquals(expected.getBase(), actual.getBase());
        assertEquals(expected.getCurrencyCode(), actual.getCurrencyCode());
        assertEquals(expected.getRate().setScale(3, RoundingMode.HALF_UP), actual.getRate().setScale(3, RoundingMode.HALF_UP));
    }

    @Test
    public void testBaseConversion() {
        from.setBase("EUR");
        from.setCurrencyCode("USD");
        from.setRate(new BigDecimal(1.121945));

        to.setBase("GBP");
        to.setCurrencyCode("USD");
        to.setRate(new BigDecimal(1.45038));

        CurrencyRateService service = mock(CurrencyRateService.class);
        baseConverterImpl.setCurrencyRateService(service);

        CurrencyRateVO actual = baseConverterImpl.convertTo(from, to);

        CurrencyRateVO expected = new CurrencyRateVO();

        expected.setBase("EUR");
        expected.setCurrencyCode("GBP");
        expected.setRate(new BigDecimal(0.773552448));

        assertEquals(expected.getBase(), actual.getBase());
        assertEquals(expected.getCurrencyCode(), actual.getCurrencyCode());
        assertEquals(expected.getRate().setScale(3, RoundingMode.HALF_UP), actual.getRate().setScale(3, RoundingMode.HALF_UP));
    }

    @Test(expected = NullPointerException.class)
    public void testFromIsNull() {
        to.setBase("GBP");
        to.setCurrencyCode("USD");
        to.setRate(new BigDecimal(1.45038));
        baseConverterImpl.convertTo(null, to);
    }

    @Test(expected = NullPointerException.class)
    public void testToIsNull() {
        from.setBase("GBP");
        from.setCurrencyCode("USD");
        from.setRate(new BigDecimal(1.45038));
        baseConverterImpl.convertTo(from, null);
    }

    @Test
    public void testOwnedCurrencyConversion() throws NoCurrencyDataException {
        ownedCurrency.setQuantity(BigDecimal.ONE);
        ownedCurrency.setCurrency("GBP");

        CurrencyRateService service = mock(CurrencyRateService.class);

        from.setBase("GBP");
        from.setCurrencyCode("USD");
        from.setRate(new BigDecimal(1.45038));

        to.setBase("EUR");
        to.setCurrencyCode("USD");
        to.setRate(new BigDecimal(1.12215));

        when(service.findLatestCurrency("GBP")).thenReturn(from);
        when(service.findLatestCurrency("EUR")).thenReturn(to);

        baseConverterImpl.setCurrencyRateService(service);

        BigDecimal actual = baseConverterImpl.getValue(ownedCurrency, "EUR");

        BigDecimal expected = new BigDecimal(1.2929644);

        assertEquals(expected.setScale(3, RoundingMode.HALF_UP), actual.setScale(3, RoundingMode.HALF_UP));
    }

    @Test
    public void testOwnedCurrencyConversionForCurrrency() throws NoCurrencyDataException {
        ownedCurrency.setQuantity(BigDecimal.ONE);
        ownedCurrency.setCurrency("GBP");

        CurrencyRateService service = mock(CurrencyRateService.class);

        from.setBase("GBP");
        from.setCurrencyCode("USD");
        from.setRate(new BigDecimal(1.45038));

        to.setBase("EUR");
        to.setCurrencyCode("USD");
        to.setRate(new BigDecimal(1.12215));

        when(service.findLatestCurrency("GBP")).thenReturn(from);
        when(service.findLatestCurrency("EUR")).thenReturn(to);

        baseConverterImpl.setCurrencyRateService(service);

        BigDecimal actual = baseConverterImpl.getValue(ownedCurrency, "EUR");

        BigDecimal expected = new BigDecimal(1.2929644);

        assertEquals(expected.setScale(3, RoundingMode.HALF_UP), actual.setScale(3, RoundingMode.HALF_UP));
    }

    @Test
    public void testOwnedCurrencyConversionForTheSameCurrency() throws NoCurrencyDataException {
        ownedCurrency.setQuantity(BigDecimal.ONE);
        ownedCurrency.setCurrency("GBP");

        CurrencyRateService service = mock(CurrencyRateService.class);

        from.setBase("GBP");
        from.setCurrencyCode("USD");
        from.setRate(new BigDecimal(1.45038));

        when(service.findLatestCurrency("GBP")).thenReturn(from);

        baseConverterImpl.setCurrencyRateService(service);

        BigDecimal actual = baseConverterImpl.getValue(ownedCurrency, "GBP");

        BigDecimal expected = new BigDecimal(BigInteger.ONE);

        assertEquals(expected.setScale(3, RoundingMode.HALF_UP), actual.setScale(3, RoundingMode.HALF_UP));
    }
}
