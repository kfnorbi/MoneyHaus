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
package hu.unideb.inf.moneyhaus.test.service.impl;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.impl.PreCalculatedRecommendationServiceImpl;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Nolbelt
 */
public class PreCalculatedRecommendationServiceImplTest {

    PreCalculatedRecommendationServiceImpl preCalculatedRecommendationServiceImpl;

    @Before
    public void setUp() {
        preCalculatedRecommendationServiceImpl = new PreCalculatedRecommendationServiceImpl();
    }

    @Test
    public void calculateRecommendationTestWhereNoDataIsDefined() {
        CurrencyRateService service = mock(CurrencyRateService.class);
        when(service.getAllManagedCurrencies()).thenReturn(Collections.EMPTY_LIST);

        preCalculatedRecommendationServiceImpl.setCurrencyRateService(service);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        assertEquals(preCalculatedRecommendationServiceImpl.calculateRecommendations(cal.getTime()), Collections.EMPTY_LIST);
    }

    @Test
    public void calculateRecommendationTestShouldReturnEmptyList() {
        CurrencyRateService service = mock(CurrencyRateService.class);
        when(service.getAllManagedCurrencies()).thenReturn(Arrays.asList("GBP"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        Date date = cal.getTime();

        when(service.findAverageOfCurrencySinceDate("GBP", date)).thenReturn(1.0);

        CurrencyRateVO rate = new CurrencyRateVO();
        rate.setBase("GBP");
        rate.setCurrencyCode("IQD");
        rate.setRate(new BigDecimal(0.4));
        when(service.findLatestCurrency("GBP")).thenReturn(rate);

        preCalculatedRecommendationServiceImpl.setCurrencyRateService(service);

        assertEquals(preCalculatedRecommendationServiceImpl.calculateRecommendations(date), Collections.EMPTY_LIST);
    }

    @Test
    public void calculateRecommendationTestForOneCurrency() {
        CurrencyRateService service = mock(CurrencyRateService.class);
        when(service.getAllManagedCurrencies()).thenReturn(Arrays.asList("GBP"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        Date date = cal.getTime();

        when(service.findAverageOfCurrencySinceDate("GBP", date)).thenReturn(1.0);

        CurrencyRateVO rate = new CurrencyRateVO();
        rate.setBase("GBP");
        rate.setCurrencyCode("IQD");
        rate.setRate(new BigDecimal(2));
        when(service.findLatestCurrency("GBP")).thenReturn(rate);

        preCalculatedRecommendationServiceImpl.setCurrencyRateService(service);

        PreCalculatedRecommendation recommendation = new PreCalculatedRecommendation();
        recommendation.setGrowth(new BigDecimal(2));
        recommendation.setCurrency("GBP");

        PreCalculatedRecommendation result = preCalculatedRecommendationServiceImpl.calculateRecommendations(date).get(0);

        assertEquals(result.getGrowth(), recommendation.getGrowth());
        assertEquals(result.getCurrency(), recommendation.getCurrency());
    }
}
