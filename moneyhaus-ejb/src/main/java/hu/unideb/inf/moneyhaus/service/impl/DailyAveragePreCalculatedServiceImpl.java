/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service.impl;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.DailyAveragePreCalculatedEntity;
import hu.unideb.inf.moneyhaus.repositories.DailyAveragePrecalculatedDao;
import hu.unideb.inf.moneyhaus.vo.DailyAveragePreCalculated;
import hu.unideb.inf.moneyhaus.service.DailyAveragePreCalculatedService;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * This class implements some basic methods to manage
 * {@link hu.unideb.inf.moneyhaus.vo.DailyAveragePreCalculated DailyAveragePreCalculated}s.
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DailyAveragePreCalculatedServiceImpl implements DailyAveragePreCalculatedService {

    /**
     * Service.
     */
    @Autowired
    DailyAveragePrecalculatedDao dailyAveragePrecalculatedDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(DailyAveragePreCalculated average) {
        dailyAveragePrecalculatedDao.save(GenericConverter.mapTo(average, DailyAveragePreCalculatedEntity.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DailyAveragePreCalculated> findByCurrencyCodeSince(String currencyCode, Date date) {
        return GenericConverter.mapTo(dailyAveragePrecalculatedDao.findByCurrencyCodeBetweenDate(currencyCode, date, new Date()), DailyAveragePreCalculated.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DailyAveragePreCalculated findLatestByCurrencyCode(String currencyCode) {
        return GenericConverter.mapTo(dailyAveragePrecalculatedDao.findLatestByCode(currencyCode), DailyAveragePreCalculated.class);
    }

    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(List<DailyAveragePreCalculated> average) {
        for (DailyAveragePreCalculated calculated : average) {
            save(calculated);
        }
    }

}
