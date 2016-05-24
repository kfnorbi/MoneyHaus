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

import com.github.sarxos.xchange.ExchangeRate;
import hu.unideb.inf.moneyhaus.converter.ExchangeRateToCurrencyVOConverter;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Nolbelt
 */
public class ExchangeRateToCurrencyVOConverterTest {

    @Test
    public void testConversionShouldWorkFine() {
        ExchangeRate rate = new ExchangeRate("USDEUR", "400");

        CurrencyRateVO currencyRate = ExchangeRateToCurrencyVOConverter.toLocal(rate);
        assertEquals(rate.getFrom(), currencyRate.getBase());
        assertEquals(rate.getRate(), currencyRate.getRate());
        assertEquals(rate.getTo(), currencyRate.getCurrencyCode());

    }

    @Test
    public void testConversionShouldWorkFineWithListParameter() {
        ExchangeRate rate = new ExchangeRate("USDEUR", "400");

        List<CurrencyRateVO> currencyRate = ExchangeRateToCurrencyVOConverter.toLocal(Arrays.asList(rate));

//        assertEquals(rate.getFrom(), currencyRate.get(0).getBase());
        assertEquals(rate.getRate(), currencyRate.get(0).getRate());
//        assertEquals(rate.getTo(), currencyRate.get(0).getCurrencyCode());
    }
}
