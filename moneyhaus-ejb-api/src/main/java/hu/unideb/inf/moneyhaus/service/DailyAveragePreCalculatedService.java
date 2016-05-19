/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public interface DailyAveragePreCalculatedService {

    public void save(DailyAveragePreCalculated average);

    public void save(List<DailyAveragePreCalculated> average);

    public List<DailyAveragePreCalculated> findByCurrencyCodeSince(String currencyCode, Date date);

    public DailyAveragePreCalculated findLatestByCurrencyCode(String currencyCode);

}
