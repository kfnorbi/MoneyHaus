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
package hu.unideb.inf.moneyhaus.refresher;

import com.github.sarxos.xchange.ExchangeQuery;
import com.github.sarxos.xchange.ExchangeRate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nolbelt
 */
public class YahooExchangeAccessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * Currencies.
     */
    private static final List<String> CURRENCIES;

    static {

        List<String> temp = new ArrayList<>();

        for (Currency c : Currency.getAvailableCurrencies()) {
            temp.add(c.getCurrencyCode());
        }

        CURRENCIES = Collections.unmodifiableList(temp);
    }
    
    /**
     * Base to calculate by.
     */
    private final String BASE = "IQD";

    public List<ExchangeRate> getExchangeRates() {
        ExchangeQuery query = new ExchangeQuery();

        List<ExchangeRate> remoteRates = new ArrayList<>();

        for (String currency : CURRENCIES) {
            Collection<ExchangeRate> rate = Collections.EMPTY_LIST;
            try {
                rate = query.to(BASE).from(currency).get();
            } catch (Exception e) {
                logger.info("Refreshing " + currency + " failed. Skipping to next entry.");
            }
            remoteRates.addAll(rate);
        }
        return remoteRates;
    }

}
